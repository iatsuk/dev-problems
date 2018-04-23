package net.iatsuk.problems.chapter11.ex07

class BitSequence(size: Int) {
  private val buf = new Array[Long](size)

  def apply(index: Int): Long = buf(index)
  def update(index: Int, value: Long) { buf(index) = value }
}

object Exercise07 extends App {
  val seq = new BitSequence(100)
  seq(99) = 42L
  println(seq(99))
}
