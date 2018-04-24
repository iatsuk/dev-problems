package net.iatsuk.problems.chapter12.ex07

object Exercise07 extends App {
  def adjustToPair(fun: (Int, Int) => Int) = (t: (Int, Int)) => fun(t._1, t._2)

  println(adjustToPair(_ * _)(6, 7))

  val pairs = (1 to 10) zip (11 to 20)
  println(pairs.map(adjustToPair(_ + _)))
}
