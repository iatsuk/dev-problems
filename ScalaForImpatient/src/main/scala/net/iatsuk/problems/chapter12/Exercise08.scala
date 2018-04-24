package net.iatsuk.problems.chapter12.ex08

object Exercise08 extends App {
  val a = Array("Hello", "World")
  val b = Array(5, 5)

  val res = a.corresponds(b)(_.length == _)
  println(res)
}
