package net.iatsuk.problems.chapter08
package ex4

import scala.collection.mutable.ArrayBuffer

abstract class Item {
  def price: Double
  def description: String
}

class SimpleItem(override val price: Double, override val description: String) extends Item {
}

class Bundle extends Item {
  private val list = new ArrayBuffer[Item]

  override def price: Double = list.map(_.price).sum

  override def description: String = "Bundle with " + list.map(_.description).mkString(", ")

  def +=(item: Item): Bundle = { list += item; this }
}

object Test extends App {
  val item1 = new SimpleItem(1.4, "Ice Cream")
  val item2 = new SimpleItem(3.0, "Pan Cake")

  val bundle = new Bundle
  bundle += item1 += item2
  printf("%s is cost $%.2f", bundle.description, bundle.price)
}