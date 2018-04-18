package net.iatsuk.problems.chapter08
package ex9

class Creature {
  def range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override def range = 2
}

object Test extends App {
  println((new Ant).env.length)
}
