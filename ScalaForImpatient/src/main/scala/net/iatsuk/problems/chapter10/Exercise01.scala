package net.iatsuk.problems.chapter10

import java.awt.geom.{Ellipse2D, RectangularShape}

trait RectangleLike extends RectangularShape {
  def translate(x: Double, y: Double): Unit = setFrame(getX + x, getY + y, getWidth, getHeight)

  def grow(x: Double, y: Double): Unit = setFrame(getX, getY, getWidth + x, getHeight + y)
}

object Exercise01 extends App {
  val egg = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
  egg.translate(10, -10)
  egg.grow(10, 20)
}
