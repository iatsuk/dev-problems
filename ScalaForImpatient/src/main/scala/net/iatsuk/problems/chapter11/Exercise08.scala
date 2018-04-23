package net.iatsuk.problems.chapter11.ex08

class Matrix(val height: Int, val width: Int) {
  private val m = Array.ofDim[Long](height, width)

  private def check(that: Matrix) {
    if (height != that.height && width != that.width) throw new IllegalArgumentException
  }

  def apply(x: Int, y: Int): Long = m(x)(y)

  def update(x: Int, y: Int, value: Long) {
    m(x)(y) = value
  }

  def +(that: Matrix): Matrix = {
    check(that)
    val result = new Matrix(height, width)
    for (i <- 0 until height; j <- 0 until width) result(i, j) = apply(i, j) + that(i, j)
    result
  }

  def *(scalar: Int): Matrix = {
    val result = new Matrix(height, width)
    for (i <- 0 until height; j <- 0 until width) result(i, j) = apply(i, j) * scalar
    result
  }

  override def toString: String = m.map(_.mkString("[", ",", "]")).reduce(_ + "\n" + _)
}

object Exercise08 extends App {
  println("A:")
  val m = new Matrix(2, 2)
  for (i <- 0 until m.height; j <- 0 until m.width) m(i, j) = i + j
  println(m + "\n")

  println("A * 2:")
  println(m * 2 + "\n")

  println("A + A * 2:")
  println(m + m * 2)
}
