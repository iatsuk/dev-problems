package net.iatsuk.problems.chapter12.ex10

object Exercise10 extends App {
  def unless(condition: => Boolean)(block: => Unit): Unit = {
    if (!condition) block
  }

  unless(4 > 6) { println("Is false")}
}
