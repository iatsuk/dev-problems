package net.iatsuk.problems.chapter12.ex1

object Exercise01 extends App {
  def values(fun: Int => Int, low: Int, high: Int) = {
    low to high map { i => (i, fun(i)) }
  }

  println(values(x => x * x, -5, 5))
}
