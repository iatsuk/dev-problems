package net.iatsuk.problems.chapter13

object Exercise04 extends App {
  def a2m(a: Array[String], map: Map[String, Int]) = a.flatMap(map.get)

  val a = Array("Tom", "Fred", "Harry")
  val m = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)
  println(a2m(a, m).mkString(", "))
}
