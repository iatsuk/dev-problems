package net.iatsuk.problems.chapter12.ex09

object Exercise09 extends App {
  val a = Array("Hello", "World")
  val b = Array(5, 5)

  val withoutCorresponds = a.zip(b).map(t => t._1.length == t._2).reduce(_ && _)
  println(withoutCorresponds)

  def corresponds[A, B](fun: (A, B) => Boolean, a: Seq[A], b: Seq[B]): Boolean = {
    val i = a.iterator
    val j = b.iterator
    while (i.hasNext && j.hasNext) {
      if (!fun(i.next(), j.next())) return false
    }
    !i.hasNext && !j.hasNext
  }

  val selfCorresponds = corresponds[String, Int](_.length == _, a, b)
  println(selfCorresponds)
}
