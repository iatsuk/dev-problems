package net.iatsuk.problems.chapter09

import scala.io.Source

object Exercise08 extends App {
  val source = Source.fromURL("http://www.scala-lang.org")
  val srcPattern = """<img.*src="(\S*)".*>""".r
  for (line <- source.getLines(); srcPattern(src) <- srcPattern.findAllIn(line)) println(src)
  source.close()
}
