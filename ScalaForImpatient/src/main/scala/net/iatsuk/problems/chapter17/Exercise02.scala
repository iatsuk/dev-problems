package net.iatsuk.problems.chapter17

object Exercise02 extends App {

  class Pair[T](var _1: T, var _2: T) {
    def swap(): Unit = {
      val buf = _1; _1 = _2; _2 = buf
    }

    override def toString: String = "MyPair(" +  String.valueOf(_1) + ", " + String.valueOf(_2) + ")"
  }

  val pair = new Pair(3, 4)
  pair.swap()
  println(pair)
}
