package net.iatsuk.problems.chapter14

object Exercise09 extends App {
  def sum(list: List[Option[Int]]) = list.map(_.getOrElse(0)).sum

  val list = List(Some(1), None, None, Some(4), Some(5))

  println(sum(list))
}
