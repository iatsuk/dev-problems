package net.iatsuk.problems.chapter09

import java.io.{File, PrintWriter}
import java.nio.file.Files

import scala.io.Source

object Exercise02 extends App {
  val file = new File("ex02.txt")

  val in = Array("abc\tdef\tghi", "jk\tl\tmn")
  val pwIn = new PrintWriter(file)
  in.foreach(pwIn.println)
  pwIn.close()

  println("in:")
  in.foreach(println)
  println()

  val colLength = 4
  val source = Source.fromFile(file)
  val out = source.getLines.
    map(line => line.split("\t").map(word => if (word.length < colLength) word + " " * (colLength - word.length) else word)).
    map(_.mkString(""))
  source.close()


  println("out:")
  out.foreach(println)
  println()

  val pwOut = new PrintWriter(file)
  out.foreach(pwOut.println)
  pwOut.close()

  Files.deleteIfExists(file.toPath)
}
