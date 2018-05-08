package net.iatsuk.problems.chapter16

import scala.io.Source
import scala.xml.parsing.XhtmlParser

object Exercise06 extends App {
  val parser = new XhtmlParser(Source.fromFile("test.html"))
  val root = parser.initialize.document().docElem
  val images = (root \\ "a").map(a => a.child.mkString -> a.attribute("href").getOrElse(""))
  images.foreach(println)
}
