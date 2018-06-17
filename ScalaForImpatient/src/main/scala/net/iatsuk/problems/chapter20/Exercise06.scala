package net.iatsuk.problems.chapter20

import java.util.concurrent.TimeUnit

import scala.actors.Actor

object Exercise06 extends App {

  println("while/receive")
  for (i <- 0 until 100) {
    val actor = new Actor() {
      override def act(): Unit = {
        while (true) receive {
          case "Hello" => println(Thread.currentThread())
        }
      }
    }.start()
    actor ! "Hello"
  }

  println("loop/react")
  for (i <- 0 until 100) {
    val actor = new Actor() {
      override def act(): Unit = {
        loop {
          react {
            case "Hello" => println(Thread.currentThread())
          }
        }
      }
    }.start()
    actor ! "Hello"
  }

  TimeUnit.MILLISECONDS.sleep(300)
  System.exit(0)
}
