package net.iatsuk.problems.chapter09

import java.io.{File, PrintWriter}
import java.nio.file.Files

import scala.io.Source

object Exercise07 extends App {
  val file = new File("ex07.txt")

  val in = Array("abcdefghijklm 12345678901234.0", "n.2", "56789 .0 opqrstuvwxyz")
  val pwIn = new PrintWriter(file)
  in.foreach(pwIn.println)
  pwIn.close()

  val source = Source.fromFile(file)
  source.mkString.split("\\s").filter(_.matches("""^(?:(?!(\d+\.\d+)).)*$""")).foreach(println)
  source.close()

  Files.deleteIfExists(file.toPath)
}
