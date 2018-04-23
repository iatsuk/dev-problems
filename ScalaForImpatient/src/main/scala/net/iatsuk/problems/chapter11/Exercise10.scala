package net.iatsuk.problems.chapter11.ex10

object RichFile {
  def unapplySeq(input: String): Option[Seq[String]] =
    if (input.trim.isEmpty) None else Some(input.trim.split(System.getProperty("file.separator")).filterNot(_.isEmpty))
}

object Exercise10 extends App {
  System.setProperty("file.separator", "/")
  val RichFile(home, user, file) = "/home/cay/readme.txt"
  println(home)
  println(user)
  println(file)
}
