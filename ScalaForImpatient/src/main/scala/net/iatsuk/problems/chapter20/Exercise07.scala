package net.iatsuk.problems.chapter20

import java.io.File
import java.nio.file.{Files, Path}
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors

import scala.actors.{Actor, Exit}
import scala.collection.JavaConverters._
import scala.io.Source
import scala.util.matching.Regex

object Exercise07 extends App {

  class DirActor(master: Actor) extends Actor {
    override def act(): Unit = {
      react {
        case task: Task => Files.list(task.path).collect(Collectors.toList()).asScala
          .foreach {
            case path if Files.isDirectory(path) => new DirActor(master).start() ! task.copy(path = path)
            case path if Files.isRegularFile(path) => new FileActor(master).start() ! task.copy(path = path)
          }
      }
    }
  }

  class FileActor(master: Actor) extends Actor {
    override def act(): Unit = {
      link(master)
      react {
        case task: Task => task.composer ! Source.fromFile(task.path.toFile).getLines().map(task.regExp.findAllIn(_).size).sum
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

  class Master(task: Task) extends Actor {

    override def act(): Unit = {
      new DirActor(this).start() ! task
      trapExit = true
      while (true) receive {
        case Exit(linked, reason) => None
      }
    }
  }

  case class Task(path: Path, regExp: Regex, composer: Actor)

  val composer = new ComposeActor().start().asInstanceOf[ComposeActor]
  val task = Task(new File(".").toPath, "e0[1|2]".r, composer)
  new Master(task).start()

  TimeUnit.MILLISECONDS.sleep(500)
  printf("Total matches: %d%n", composer.result)
  System.exit(0)
}
