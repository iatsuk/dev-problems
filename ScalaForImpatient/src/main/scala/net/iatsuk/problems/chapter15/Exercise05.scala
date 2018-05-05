package net.iatsuk.problems.chapter15

import scala.io.Source

object Exercise05 {

  def readFile(file: String): String = {
    val source = Source.fromFile(file)
    val result = source.getLines().mkString("\n")
    source.close()
    result
  }
}
