package net.iatsuk.problems.chapter10

import java.awt.Point

class OrderedPoint(x: Int, y: Int) extends Point(x, y) with scala.math.Ordered[Point] {
  override def compare(that: Point): Int = {
    if (x < that.x || (x == that.x && y < that.y)) -1 else if (x == that.x && y == that.y) 0 else 1
  }
}

object OrderedPoint {
  implicit def ordering[T <: OrderedPoint] : Ordering[T] = new Ordering[T] {
    override def compare(x: T, y: T): Int = x.compare(y)
  }
}

object Exercise02 extends App {
  val points = Array(
    new OrderedPoint(25, 25),
    new OrderedPoint(25, 25),
    new OrderedPoint(12, 25),
    new OrderedPoint(25, 14)
  )
  points.sorted.foreach(println)
}
