package net.iatsuk.problems.chapter16

import scala.io.Source
import scala.xml._
import scala.xml.parsing.XhtmlParser
import scala.xml.transform.{RewriteRule, RuleTransformer}

object Exercise10 extends App {
  val parser = new XhtmlParser(Source.fromFile("test.html"))
  val root = parser.initialize.document().docElem

  val rule = new RewriteRule {
    override def transform(n: Node): Seq[Node] = n match {
      case e @ <img /> if e.attribute("alt").isEmpty => e.asInstanceOf[Elem] % Attribute(null, "alt", "TODO", Null)
      case _ => n
    }
  }
  val transformed = new RuleTransformer(rule).transform(root)

  val printer = new PrettyPrinter(width = 100, step = 4, minimizeEmpty = true)
  val str = printer.formatNodes(transformed)
  println(str)
}
