package net.iatsuk.problems.chapter16

import scala.xml.Node

object Exercise08 extends App {
  def xml2map(xml: Node): Map[String, String] = {
    xml.child.grouped(4).map(n => n.head.child.mkString -> n(2).child.mkString).toMap
  }

  println(xml2map(<dl><dt>A</dt> <dd>1</dd> <dt>B</dt> <dd>2</dd></dl>))
}
