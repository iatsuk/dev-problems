package net.iatsuk.problems.chapter10

trait Person {
  val name: String

  def voice(speech: String): Unit = println(speech)
}

trait Sanguine extends Person {
  override def voice(speech: String): Unit = super.voice(speech)
}

trait Phlegmatic extends Person {
  override def voice(speech: String): Unit = super.voice(speech + "... ")
}

trait Choleric extends Person {
  override def voice(speech: String): Unit = super.voice((" " + speech) * 3)
}

trait Melancholic extends Person {
  override def voice(speech: String): Unit = super.voice(speech + " :( ")
}

class Baby extends Melancholic with Choleric {
  override val name: String = "Tom"
}

object Exercise07 extends App {
  val tom = new Baby
  tom.voice("Hi! My name is " + tom.name + ".")
}
