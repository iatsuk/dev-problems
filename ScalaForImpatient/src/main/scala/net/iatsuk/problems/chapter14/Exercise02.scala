package net.iatsuk.problems.chapter14

object Exercise02 extends App {
  def swap(a: Int, b: Int) = (b, a)

  def matchSwap(a: (Int, Int)) = a match {
    case (x, y) => (y, x)
  }

  val (a, b) = swap(3, 4)
  println(a + ", " + b)

  val (c, d) = matchSwap(3, 4)
  println(c + ", " + d)
}
