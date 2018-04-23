package net.iatsuk.problems.chapter11.ex01

class Num(val int: Int) {
  def +(that: Num) = new Num(this.int + that.int)

  def -(that: Num) = new Num(this.int - that.int)

  def ->(that: Num) = new Num(that.int)

  override def toString = s"Num($int)"
}

object Num {
  def apply(int: Int): Num = new Num(int)
}

object Exercise01 extends App {
  println(Num(3) + Num(4) -> Num(5))
  println(Num(3) -> Num(4) + Num(5))
}
