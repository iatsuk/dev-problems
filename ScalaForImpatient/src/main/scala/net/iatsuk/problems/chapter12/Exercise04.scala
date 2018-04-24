package net.iatsuk.problems.chapter12.ex04

object Exercise04 extends App {
  def fact(n: Int): Long = (1 to n).foldLeft(1)(_*_)
  println(fact(-3))
  println(fact(5))
}
