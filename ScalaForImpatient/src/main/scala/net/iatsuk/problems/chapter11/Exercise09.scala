package net.iatsuk.problems.chapter11.ex09

object RichFile {
  def unapply(input: String): Option[(String, String, String)] = {
    val lastSlash = input.lastIndexOf(System.getProperty("file.separator"))
    val lastDot = input.lastIndexOf(".")
    if (lastSlash < 0 || lastDot < lastSlash) {
      None
    } else {
      val path = input.substring(0, lastSlash)
      val fileName = input.substring(lastSlash + 1, lastDot)
      val extension = input.substring(lastDot + 1)
      Some(path, fileName, extension)
    }
  }
}

object Exercise09 extends App {
  System.setProperty("file.separator", "/")
  val RichFile(path, fileName, extension) = "/home/cay/readme.txt"
  println(path)
  println(fileName)
  println(extension)
}
