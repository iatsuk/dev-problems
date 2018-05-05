package net.iatsuk.problems.chapter15

object Exercise08 {

  def allDifferent[@specialized T](x: T, y: T, z: T): Boolean = x != y && x != z && y != z
}
