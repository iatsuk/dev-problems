package net.iatsuk.problems.chapter11.ex04

class Money(d: Int, c: Int) {
  private val dollars: Int = if (c > 0) d + c / 100 else if (c < 0) d + c / 100 - 1 else d
  private val cents: Int = if (c >= 0) c % 100 else 100 + c % 100
  override def toString: String = "$%d.%d".format(dollars, cents)
  def +(that: Money): Money = new Money(dollars + that.dollars, cents + that.cents)
  def -(that: Money): Money = new Money(dollars - that.dollars, cents - that.cents)
  def ==(that: Money): Boolean = dollars == that.dollars && cents == that.cents
  def >(that: Money): Boolean = if (dollars == that.dollars) cents > that.cents else dollars > that.dollars
  def <(that: Money): Boolean = !(this > that)
}

object Exercise04 extends App {
  println(new Money(1, -1))
  println(new Money(15, 25))
  println(new Money(15, 225))
  println(new Money(15, -25))
  println(new Money(15, -225))
  println(new Money(15, 25) + new Money(15, 76))
  println(new Money(15, 25) - new Money(4, 26))
}
