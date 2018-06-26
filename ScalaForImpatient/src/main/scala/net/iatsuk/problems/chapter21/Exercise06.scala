package net.iatsuk.problems.chapter21
import java.awt.Point

object Exercise06 extends App {
  class RichPoint(point: java.awt.Point) extends Ordered[java.awt.Point] {
    override def compare(that: Point): Int = point.toString.compareTo(that.toString)
  }

  implicit def point2RichPoint(point: java.awt.Point): RichPoint = new RichPoint(point)

  val point1 = new java.awt.Point(1, 2)
  val point2 = new java.awt.Point(2, 1)
  println(point1.toString, if (point1 < point2) "<" else ">", point2.toString)
}
