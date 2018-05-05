package net.iatsuk.problems.chapter15

import java.util.concurrent.TimeUnit

object Exercise06 extends App {

  @volatile var bool = false

  new Thread(new Runnable {
    override def run(): Unit = {
      TimeUnit.SECONDS.sleep(1)
      bool = true
      println("Bool was set as TRUE")
    }
  }).run()

  new Thread(new Runnable {
    override def run(): Unit = {
      while (!bool) TimeUnit.MILLISECONDS.sleep(100)
      println("Bool is really true")
    }
  }).run()

}
