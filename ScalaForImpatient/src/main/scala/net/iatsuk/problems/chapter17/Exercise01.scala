package net.iatsuk.problems.chapter17

object Exercise01 extends App {

  class Pair[T, S](val _1: T, val _2: S) {
    override def toString: String = "MyPair(" +  String.valueOf(_1) + ", " + String.valueOf(_2) + ")"
  }

  def swap[T, S](pair: Pair[T, S]): Pair[S, T] = new Pair(pair._2, pair._1)

  val pair = new Pair(3, "Four")
  println(swap(pair))
}
