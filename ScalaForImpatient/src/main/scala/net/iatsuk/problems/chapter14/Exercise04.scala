package net.iatsuk.problems.chapter14

object Exercise04 extends App {

  sealed abstract class Item

  case class Product(description: String, price: Double) extends Item

  case class Bundle(description: String, discount: Double, items: Item*) extends Item

  case class Multiple(amount: Int, item: Item) extends Item

  def price(it: Item): Double = it match {
    case Product(_, p) => p
    case Bundle(_, disc, its@_*) => its.map(price).sum - disc
    case Multiple(amount, item) => price(item) * amount
  }

  val tomato = Product("Tomato", 1.99)
  val potato = Product("Potato", 0.99)
  val homeProducts = Bundle("Special", 0.50, tomato, potato)
  val multiple = Multiple(10, homeProducts)

  println(price(tomato))
  println(price(homeProducts))
  println(price(multiple))
}
