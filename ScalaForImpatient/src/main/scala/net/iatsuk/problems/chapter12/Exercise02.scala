package net.iatsuk.problems.chapter12.ex02

object Exercise02 extends App {
  val a = Array(5, 25, 4, 16, 3, 9, 2, 4, 1, 1)
  println(a.reduceLeft(Math.max))
}
