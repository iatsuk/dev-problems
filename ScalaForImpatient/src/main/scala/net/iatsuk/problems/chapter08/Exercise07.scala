package net.iatsuk.problems.chapter08
package ex7

class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width) {
  def this(width: Int) = this(0, 0, width)
  def this() = this(0)

  override def toString = s"Square(x=$x, y=$y, width=$width)"
}

object Test extends App {
  println(new Square())
}