package net.iatsuk.problems.chapter21

object Exercise01 extends App {
  val pair = Predef.any2ArrowAssoc("Hello").->(42)
  println(pair)
}
