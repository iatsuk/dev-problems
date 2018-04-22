package net.iatsuk.problems.chapter10

trait Logger {
  def log(msg: String) { }
}

trait ConsoleLogger extends Logger {
  override def log(msg: String): Unit = println(msg)
}

trait CryptoLogger extends Logger{
  val offset = 3

  override def log(msg: String): Unit = {
    val sb = new StringBuilder
    for (c <- msg) sb.append((c + offset).toChar)
    super.log(sb.mkString)
  }
}

object Exercise04 extends App {
  val o1 = new AnyRef with ConsoleLogger with CryptoLogger
  o1.log("Hello, World")

  val o2 = new {override val offset = 0} with AnyRef with ConsoleLogger with CryptoLogger
  o2.log("Hello, World")

  val o3 = new {override val offset = -3} with AnyRef with ConsoleLogger with CryptoLogger
  o3.log("Hello, World" + "#####Khoor/#Zruog")
}
