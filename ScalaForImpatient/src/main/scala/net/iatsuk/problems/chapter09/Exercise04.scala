package net.iatsuk.problems.chapter09

import java.io.{File, PrintWriter}
import java.nio.file.Files

import scala.io.Source

object Exercise04 extends App {
  val file = new File("ex04.txt")

  val in = Array("3.1415 1234 56789.01234", "2.71", "5.67890")
  val pwIn = new PrintWriter(file)
  in.foreach(pwIn.println)
  pwIn.close()

  val source = Source.fromFile(file)
  var doubles = source.mkString.split("\\s").map(_.toDouble)
  source.close()
  printf("sum: %.2f\n", doubles.sum)
  printf("max: %.2f\n", doubles.max)
  printf("min: %.2f\n", doubles.min)
  printf("avg: %.2f\n", doubles.sum / doubles.length)

  Files.deleteIfExists(file.toPath)
}
