package net.iatsuk.problems.chapter13

import scala.collection.mutable

object Exercise03 extends App {
  def removeZeros(list: mutable.LinkedList[Int]): Unit = {
    var cur = list
    while (cur.next.nonEmpty) {
      if (cur.next.elem == 0)
        cur.next = cur.next.next
      else
        cur = cur.next
    }
  }

  val list = mutable.LinkedList(1, 0, 2, 3, 0, 0, 0, 4, 0, 0)
  removeZeros(list)
  println(list)
}
