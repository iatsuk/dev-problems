package net.iatsuk.problems.chapter11.ex02

class Num(val int: Double) {
  def *(that: Num) = new Num(this.int * that.int)

  def **(that: Num) = new Num(Math.pow(this.int, that.int).toInt)

  override def toString = s"Num($int)"
}

object Num {
  def apply(int: Double): Num = new Num(int)
}

object Exercise02 extends App {
  println(Num(2) * Num(2) ** Num(3))
  println(Num(2) ** Num(3) * Num(2))
}
