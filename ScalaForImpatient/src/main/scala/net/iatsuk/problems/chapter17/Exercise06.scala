package net.iatsuk.problems.chapter17

object Exercise06 extends App {
  def middle[T](iterable: Iterable[T]): T = iterable.drop(iterable.size / 2).head

  println(middle("World"))
}
