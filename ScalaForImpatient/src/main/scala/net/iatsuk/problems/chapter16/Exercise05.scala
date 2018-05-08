package net.iatsuk.problems.chapter16

import scala.io.Source
import scala.xml.parsing.XhtmlParser

object Exercise05 extends App {
  val parser = new XhtmlParser(Source.fromFile("/Users/yatsukav/Documents/dev/dev-problems/ScalaForImpatient/src/main/scala/net/iatsuk/problems/chapter16/test.html"))
  val root = parser.initialize.document().docElem
  val images = (root \\ "img").flatMap(_.attribute("src").getOrElse(Seq()))
  images.foreach(println)
}
