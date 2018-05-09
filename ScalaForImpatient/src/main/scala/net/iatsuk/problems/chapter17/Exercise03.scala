package net.iatsuk.problems.chapter17

object Exercise03 extends App {

  class Pair[T, S](val _1: T, val _2: S) {
    def swap(pair: (T, S)) = new Pair(pair._2, pair._1)

    override def toString: String = "MyPair(" +  String.valueOf(_1) + ", " + String.valueOf(_2) + ")"
  }

  val pair = new Pair(3, "Four")
  println(pair.swap(3, "Four"))
}
