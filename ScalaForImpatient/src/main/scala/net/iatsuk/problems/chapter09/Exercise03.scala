package net.iatsuk.problems.chapter09

import java.io.{File, PrintWriter}
import java.nio.file.Files

import scala.io.Source

object Exercise03 extends App {
  val file = new File("ex03.txt")

  val in = Array("abcdefghijklm 12345678901234", "n", "567890 opqrstuvwxyz")
  val pwIn = new PrintWriter(file)
  in.foreach(pwIn.println)
  pwIn.close()

  val source = Source.fromFile(file)
  source.mkString.split("\\s").filter(_.length >= 12).foreach(println)
  source.close()

  Files.deleteIfExists(file.toPath)
}
