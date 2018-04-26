package net.iatsuk.problems.chapter13

object Exercise06 extends App {
  val lst = List(1, 2, 3, 4, 5, 6)

  val res1 = (lst :\ List[Int]())(_ :: _)
  println(res1)

  val res2 = (List[Int]() /: lst)(_ :+ _)
  println(res2)
}
