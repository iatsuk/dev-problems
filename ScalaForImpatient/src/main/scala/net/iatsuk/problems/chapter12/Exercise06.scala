package net.iatsuk.problems.chapter12.ex06

object Exercise06 extends App {
  def largest(fun: Int => Int, inputs: Seq[Int]): Int = inputs.maxBy(x => fun(x))

  println(largest(x => 10 * x - x * x, 1 to 10))
}
