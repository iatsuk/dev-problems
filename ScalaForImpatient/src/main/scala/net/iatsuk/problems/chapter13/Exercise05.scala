package net.iatsuk.problems.chapter13

object Exercise05 extends App {
  def mkStr[T](a: Array[T]) = a.foldLeft("")(_ + _)

  def mkStr[T](a: Array[T], sep: String) = a.foldLeft("")(_ + _ + sep).dropRight(sep.length)

  val a = Array(1, 2, 3, 4, 5)
  println(mkStr(a))
  println(mkStr(a, ", "))
}
