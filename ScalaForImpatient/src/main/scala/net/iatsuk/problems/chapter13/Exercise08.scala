package net.iatsuk.problems.chapter13

object Exercise08 extends App {
  def toCols(a: Array[Double], n: Int) = a.grouped(n).toArray

  val d = Array[Double](1, 2, 3, 4, 5, 6)
  println(toCols(d, 3).map(_.mkString(", ")).mkString("\n"))
}
