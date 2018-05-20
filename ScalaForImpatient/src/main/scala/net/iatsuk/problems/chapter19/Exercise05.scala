package net.iatsuk.problems.chapter19

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

// TODO: not implemented yet
object Exercise05 extends App {

  class XmlParser extends RegexParsers {
    private val tag = "\\w*".r
    private val rawText: Regex = "[\\w*\\s*]*".r

    def text: Parser[String] = (("\"" ~ rawText ~ "\"") | ("\'" ~ rawText ~ "\'")) ^^ (t => t._1._1 + t._1._2 + t._2)

    def emptyNode: Parser[String] = "<" ~ tag ~ "/>" ^^ (t => t._1._1 + t._1._2 + t._2)

    def node: Parser[String] = "<" ~ tag ~ "/>" ~ (opt(xml) ^^ { case Some(o) => o; case None => "" }) into { t =>
      val parsedTag = t._1._1._2
      val inner = t._2

      s"<$parsedTag>$inner</$parsedTag>"
    }

    val xml: Parser[String] = text | emptyNode | node

  }

  val testXml =
    """
      |<root>
      |  <ident> some text</ident>
      |  <ident><![CDATA[<sender>John Smith</sender>]]></ident>
      |  <ident/>
      |</root>
    """.stripMargin

  val parser = new XmlParser
  val result = parser.parseAll(parser.xml, """<root>'gtub'</root>""")
  println(result.get)
}
