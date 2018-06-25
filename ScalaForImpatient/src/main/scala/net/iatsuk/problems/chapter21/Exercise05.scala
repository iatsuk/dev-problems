package net.iatsuk.problems.chapter21

object Exercise05 extends App {

  case class Fraction(n: Int, d: Int)

  class RichFraction(fraction: Fraction) extends Ordered[Fraction] {
    override def compare(that: Fraction): Int = (fraction.n.toDouble / fraction.d).compareTo(that.n.toDouble / that.d)
  }

  implicit def fraction2RichFraction(fraction: Fraction): RichFraction = new RichFraction(fraction)

  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) = if (a < b) a else b

  println(smaller(Fraction(1, 7), Fraction(2, 9)))
}
