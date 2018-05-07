package net.iatsuk.problems.chapter16

object Exercise01 extends App {
  val xml0 = <fred/>(0)
  val xml00 = <fred/>(0)(0)

  println(xml0 == <fred/>.head)
  println(xml00 == <fred/>.head.head)
}
