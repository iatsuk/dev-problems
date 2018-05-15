package net.iatsuk.problems.chapter18

import scala.annotation.tailrec

object Exercise06 extends App {
  def nearest(sorted: Array[Int], int: Int): Int Either Int = {
    @tailrec def nearest(a: Array[Int], i: Int, start: Int, end: Int): Int Either Int = {
      val mid = (end + start) / 2
      if (end - start <= 1) {
        Either.cond(math.abs(a(start) - i) < math.abs(a(end) - i), start, end)
      } else if (a(mid) > i) nearest(a, i, start, mid) else nearest(a, i, mid, end)
    }

    nearest(sorted, int, 0, sorted.length - 1)
  }

  println(nearest(Array(2, 4, 8, 16, 32), 16))
  println(nearest(Array(2, 4, 8, 16, 32), 7))
}
