package net.iatsuk.problems.chapter14

object Exercise03 extends App {
  def swap1(a: Array[Int]) = a match {
    case Array(x, y, _*) => Array(y, x) ++ a.tail.tail
    case _ => a
  }

  def swap2(a: Array[Int]) = a match {
    case Array(x, y, rest @ _*) => Array(y, x) ++ rest
    case _ => a
  }

  println(swap1(Array(1, 2, 3, 4, 5)).mkString(", "))
  println(swap1(Array(1, 2)).mkString(", "))
  println(swap1(Array(1)).mkString(", "))
}
