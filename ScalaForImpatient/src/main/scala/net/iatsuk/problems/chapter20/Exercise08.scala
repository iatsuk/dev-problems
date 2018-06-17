package net.iatsuk.problems.chapter20

import scala.actors.Actor

object Exercise08 extends App {

  class SyncActor(name: String) extends Actor {
    override def act(): Unit = {
      loop {
        react {
          case a: Actor => println(a !? name)
          case s: String => sender ! s"$s win"
        }
      }
    }
  }

  val a1 = new SyncActor("a1").start()
  val a2 = new SyncActor("a2").start()

  a1 ! a2
  a2 ! a1
}
