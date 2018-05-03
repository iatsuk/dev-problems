package net.iatsuk.problems.chapter14

object Exercise05 extends App {
  def leafSum(list: List[Any]): Int = {
    list.collect {
      case a: List[Any] => leafSum(a)
      case x: Int => x
    }.sum
  }

  val list: List[Any] = List(List(3, 8), 2, List(5))

  println(leafSum(list))
}
