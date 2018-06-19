package net.iatsuk.problems.chapter21

object Exercise02 extends App {

  case class RichInt(int: Int) {
    def +%(percent: Int): Int = int + int * percent / 100
  }

  implicit def int2Percentable(n: Int): RichInt = RichInt(n)

  val result = 120 +% 10
  println(result)
}
