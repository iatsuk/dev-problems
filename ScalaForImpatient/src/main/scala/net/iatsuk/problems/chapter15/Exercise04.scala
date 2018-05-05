package net.iatsuk.problems.chapter15

import scala.annotation.varargs

object Exercise04 {

  @varargs
  def sum(elems: Int*): Int = elems.sum
}
