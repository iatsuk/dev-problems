// 1
object Conversions {
  def inchesToCentimeters(inches: Double) = inches * 2.54
  def gallonsToLiters(gallons: Double) = gallons * 3.785411784
  def milesToKilometers(miles: Double) = miles * 1.60934
}

// 2
abstract class UnitConversions {
  def apply(value: Double): AnyVal
}
class InchesToCentimeters extends UnitConversions {
  override def apply(value: Double) = value * 2.54
}
class GallonsToLiters extends UnitConversions {
  override def apply(value: Double) = value * 3.785411784
}
class MilesToKilometers extends UnitConversions {
  override def apply(value: Double) = value * 1.60934
}

// 3
object Point extends java.awt.Point {}

// 4
class newPoint(x: Int, y: Int) extends java.awt.Point(x, y) { }
object newPoint {
  def apply(x: Int, y: Int): newPoint = new newPoint(x, y)
}
newPoint(3, 4)

// 5
val args = Array("Hello", "World")
print(args.reverse.mkString(" "))

// 6
object Suit extends Enumeration {
  val Clubs = Value("♣")
  val Diamonds = Value("♦")
  val Hearts = Value("♥")
  val Spades = Value("♠")
}

// 7
def isRedSuit(suit: Suit.Value) = {
  suit == Suit.Diamonds || suit == Suit.Hearts
}
isRedSuit(Suit.Clubs)
isRedSuit(Suit.Hearts)

// 8
object RGB extends Enumeration {
  val Red = Value(0xFF0000)
  val Green = Value(0x00FF00)
  val Blue = Value(0x0000FF)
  val Black = Value(0x000000)
  val White = Value(0xFFFFFF)
  val Yellow = Value(0xFFFF00)
  val Purple = Value(0xFF00FF)
  val Cyan = Value(0x00FFFF)
}
