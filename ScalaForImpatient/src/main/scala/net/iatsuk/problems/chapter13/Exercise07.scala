package net.iatsuk.problems.chapter13

object Exercise07 extends App {
  val prices = List(5.0, 20.0, 9.95)
  val quantities = List(10, 2, 1)

  val result = (prices, quantities).zipped map {_ * _}
  println(result)

  val result2 = prices zip quantities map Function.tupled(_ * _)
  println(result2)
}
