package net.iatsuk.problems.chapter11.ex06

class AsciiArt(img: String) {
  val height: Int = img.split("\n").length
  val width: Int = img.split("\n").map(_.length).max
  val image: String = img.split("\n")
    .map(s => if (s.length < width) s + " " * (width - s.length) else s)
    .reduce(_ + "\n" + _)

  def +(that: AsciiArt): AsciiArt = {
    val thisImg = if (height < that.height) image + ((" " * width + "\n") * (that.height - height)) else image
    val zipped = thisImg.split("\n").zip(that.image.split("\n"))
    val newImg = zipped.map(t => t._1 + " " + t._2).reduce(_ + "\n" + _)
    new AsciiArt(newImg)
  }

  def ->(that: AsciiArt): AsciiArt = new AsciiArt(image + "\n" + that.image)

  def show(): Unit = println(image)
}

object AsciiArt {
  val man: AsciiArt = new AsciiArt(
    " /\\_/\\\n" +
      "( . . )\n" +
      "(  -  )\n" +
      " | | |\n" +
      "(__|__)")

  val hello: AsciiArt = new AsciiArt(
      "   -----\n" +
      " / Hello \\\n" +
      "<  Scala  |\n" +
      " \\ Coder /\n" +
      "   -----")
}

object Exercise06 extends App {
  AsciiArt.man + AsciiArt.hello show()
}
