package net.iatsuk.problems.chapter16

import scala.xml.{Node, NodeBuffer}

object Exercise07 extends App {
  def map2xml(map: Map[String, String]): Seq[Node] = {
    var xml = <dl></dl>
    for ((k, v) <- map) xml = xml.copy(child = xml.child ++ <dt>{k}</dt><dd>{v}</dd>)
    xml
  }

  def map2xml2(map: Map[String, String]): Seq[Node] = {
    val xml = new NodeBuffer
    for ((k, v) <- map) xml += (<dt>{k}</dt>, <dd>{v}</dd>)
    <dl>{xml}</dl>
  }

  def map2xml3(map: Map[String, String]): Seq[Node] = {
    <dl>{for ((k, v) <- map) yield <dt>{k}</dt><dd>{v}</dd>}</dl>
  }

  println(map2xml(Map("A" -> "1", "B" -> "2")))
  println(map2xml2(Map("A" -> "1", "B" -> "2")))
  println(map2xml2(Map("A" -> "1", "B" -> "2")))

}
