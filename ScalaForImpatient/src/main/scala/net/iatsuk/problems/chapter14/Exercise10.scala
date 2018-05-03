package net.iatsuk.problems.chapter14

object Exercise10 extends App {
  def compose(f: Double => Option[Double], g: Double => Option[Double]): Double => Option[Double] = {
    x: Double => f(x) match {
      case Some(y) => g(y)
      case None => None
    }
  }

  def f(x: Double) = if (x != 1) Some(1 / (x - 1)) else None
  def g(x: Double) = if (x >= 0) Some(math.sqrt(x)) else None
  val h = compose(f, g)

  println(h(2))
  println(h(1))
  println(h(0))
}
