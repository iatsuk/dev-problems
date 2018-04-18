package net.iatsuk.problems.chapter08
package ex6

abstract class Shape {
  def centerPoint: Point
}

object Point {
  def apply(x: Double, y: Double): Point = new Point(x, y)
  def avg(p1: Point, p2: Point): Point = (p1 + p2) / 2
}

class Point(val x: Double, val y: Double) extends Shape {
  def +(that: Point) = new Point(that.x + this.x, that.y + this.y)
  def -(that: Point) = new Point(that.x - this.x, that.y - this.y)
  def /(value: Double) = new Point(this.x / value, this.y / value)
  override def centerPoint: Point = this
}

class Rectangle(val p1: Point, val p4: Point) extends Shape {
  override def centerPoint: Point = Point.avg(p1, p4)
}

class Circle(val p: Point, val r: Double) extends Shape {
  override def centerPoint: Point = p
}