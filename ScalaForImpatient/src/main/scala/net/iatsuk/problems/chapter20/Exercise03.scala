package net.iatsuk.problems.chapter20

import java.io.File
import java.nio.file.{Files, Path}
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors

import scala.actors.Actor
import scala.collection.JavaConverters._
import scala.io.Source
import scala.util.matching.Regex

object Exercise03 extends App {

  case class Task(path: Path, regExp: Regex, composer: Actor)

  class DirActor extends Actor {
    override def act(): Unit = {
      react {
        case task: Task => Files.list(task.path).collect(Collectors.toList()).asScala
          .foreach {
            case path if Files.isDirectory(path) => new DirActor().start() ! task.copy(path = path)
            case path if Files.isRegularFile(path) => new FileActor().start() ! task.copy(path = path)
          }
      }
    }
  }

  class FileActor extends Actor {
    override def act(): Unit = {
      react {
        case task: Task => try {
          task.composer ! Source.fromFile(task.path.toFile).getLines().map(task.regExp.findAllIn(_).size).sum
        } catch {
          case _: Throwable => None
        }
      }
    }
  }

  class ComposeActor extends Actor {
    private var count = 0

    def result: Int = count

    override def act(): Unit = {
      while (true) {
        receive {
          case matches: Int => count += matches
        }
      }
    }
  }

  Actor.actor {
    val dir = new File(".")
    val regExp = "e0[1|2]".r
    val composer = new ComposeActor().start().asInstanceOf[ComposeActor]

    new DirActor().start() ! Task(dir.toPath, regExp, composer)

    TimeUnit.MILLISECONDS.sleep(300)
    printf("Total matches: %d%n", composer.result)
    System.exit(0)
  }
}
