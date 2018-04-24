package net.iatsuk.problems.chapter12.ex03

object Exercise03 extends App {
  def fact(n: Int): Long = 1 to n reduceLeft(_*_)
  println(fact(5))
}
