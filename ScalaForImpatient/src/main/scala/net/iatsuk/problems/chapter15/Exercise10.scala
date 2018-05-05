package net.iatsuk.problems.chapter15

object Exercise10 extends App {

  def factorial(n: Int): Int = {
    assert(n >= 0)
    (1 to n).product
  }

  println(factorial(3))
  println(factorial(0))
  println(factorial(-1))
}
