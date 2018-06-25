package net.iatsuk.problems.chapter21

import scala.collection.mutable

object Exercise04 extends App {

  sealed trait aVal
  case object aString extends aVal
  case object aInt extends aVal
  case object aDouble extends aVal

  object Read {
    private val obtained = mutable.HashMap[String, Any]()
    private var last: aVal = aString

    def in(aval: aVal): this.type = {
      last = aval
      this
    }

    def and(aval: aVal): this.type = in(aval)

    def askingFor(question: String): this.type = {
      println(question)
      val result = last match {
        case _: aString.type => io.StdIn.readLine()
        case _: aInt.type => io.StdIn.readInt()
        case _: aDouble.type => io.StdIn.readDouble()
      }
      obtained += question -> result
      this
    }

    def unapply(arg: Read.type): Map[String, Any] = obtained.toMap
  }

  val result = Read in aString askingFor "Your name" and aInt askingFor "Your age" and aDouble askingFor "Your weight"
  println(Read.unapply(result))
}
