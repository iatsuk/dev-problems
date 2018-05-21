package net.iatsuk.problems.chapter19

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

// TODO: not implemented yet
object Exercise05 extends App {

  class XmlParser extends RegexParsers {
    private val tag = "\\w*".r
    private val rawText: Regex = "[\\w*\\s*]*".r

    def text: Parser[String] = (("\"" ~ rawText <~ "\"") | ("\'" ~ rawText <~ "\'")) ^^ (t => t._1 + t._2 + t._1)

    def emptyNode: Parser[String] = "<" ~> tag <~ "/>" ^^ {
      case parsedTag if parsedTag == "ident" => s"<$parsedTag/>"
      case _ => ""
    }

    def node: Parser[String] = "<" ~> tag <~ ">" into { parsedTag =>
      (opt(xml) ^^ { case Some(o) => o; case None => "" }) <~ ("</" ~ parsedTag ~ ">") ^^ {
        case entrails if parsedTag == "ident" => s"<$parsedTag>$entrails</$parsedTag>"
        case entrails => entrails
      }
    }

    val xml: Parser[String] = rep(emptyNode | node | text) ^^ {
      _.foldLeft("")(_ + _)
    }

  }

  val testXml =
    """
      |<root>
      |  <ident>" some text"</ident>
      |  <ident>'<![CDATA[<sender>John Smith</sender>]]>'</ident>
      |  <ident/>
      |</root>
    """.stripMargin

  val parser = new XmlParser
  val result = parser.parseAll(parser.xml, """<root><ident>" some text"</ident><ident/><rot/></root>""")
  println(result.get)
}
