package net.iatsuk.problems.chapter07

package object random {

  private var previous = 1
  private val a = 1664525
  private val b = 1013904223
  private val n = 32

  def nextInt(): Int = {
    nextDouble().toInt
  }

  def nextDouble(): Double = {
    val result = previous * a + b % math.pow(2, n)
    previous = result.toInt; result
  }

  def setSeed(seed: Int): Unit = {
    previous = seed
  }
}

package main {
  object Application extends App {
    println(random.nextInt())
    println(random.nextInt())
    println()

    random.setSeed(42)
    println(random.nextDouble())
    println(random.nextDouble())
    println()

    random.setSeed(42)
    println(random.nextDouble())
    println(random.nextDouble())
  }
}