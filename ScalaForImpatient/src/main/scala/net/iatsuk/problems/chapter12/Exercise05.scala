package net.iatsuk.problems.chapter12.ex05

object Exercise05 extends App {
  def largest(fun: Int => Int, inputs: Seq[Int]): Int = inputs.map(fun).max

  println(largest(x => 10 * x - x * x, 1 to 10))
}
