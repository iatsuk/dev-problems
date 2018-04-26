package net.iatsuk.problems.chapter13

object Exercise02 extends App {

  def indexes(string: String) = (0 until string.length).foldLeft(Map[Char, Vector[Int]]()) {
    (m, i) => m + (string(i) -> m.getOrElse(string(i), Vector()).:+(i))
  }

  println(indexes("Mississippi"))
}
