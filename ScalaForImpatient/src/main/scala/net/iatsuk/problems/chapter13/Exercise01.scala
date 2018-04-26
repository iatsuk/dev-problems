package net.iatsuk.problems.chapter13

object Exercise01 extends App {

  def indexes(string: String) = string.zipWithIndex.groupBy(_._1).mapValues(_.map(_._2))

  println(indexes("Mississippi"))
}
