package net.iatsuk.problems.chapter21

object Exercise03 extends App {

  case class RichInt(int: Int) {
    def ! : Int = if (int == 1) 1 else int * RichInt(int - 1).!
  }

  implicit def int2Factorial(n: Int): RichInt = RichInt(n)

  val result = 5!

  println(result)
}
