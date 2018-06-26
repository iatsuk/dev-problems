package net.iatsuk.problems.chapter21

import java.awt.Point

object Exercise07 extends App {

  class RichPoint(point: java.awt.Point) extends Ordered[java.awt.Point] {
    def length: Double = math.sqrt(point.getX * point.getX + point.getY * point.getY)

    override def compare(that: Point): Int = point.length.compareTo(that.length)
  }

  implicit def point2RichPoint(point: java.awt.Point): RichPoint = new RichPoint(point)

  val point1 = new java.awt.Point(1, 1)
  val point2 = new java.awt.Point(0, 2)
  println(point1.length, if (point1 < point2) "<" else ">", point2.length)
}
