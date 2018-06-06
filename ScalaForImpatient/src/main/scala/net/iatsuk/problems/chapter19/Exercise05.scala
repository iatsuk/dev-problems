package net.iatsuk.problems.chapter19

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers
import scala.xml.{Attribute, NodeSeq, Null, Text}

object Exercise05 extends App {

  class XmlParser extends RegexParsers {
    private val tag = "\\w*".r
    private val text: Regex = "[^<>]*".r
    private val singleQuoteAttribute = """\s*(\w*)\s*=\s*'([^<>']*)'\s*""".r
    private val doubleQuoteAttribute = """\s*(\w*)\s*=\s*"([^<>"]*)"\s*""".r
    private val openBracket = "\\s*<\\s*".r
    private val closeBracket = "\\s*>\\s*".r

    def attribute: Parser[List[Attribute]] = rep(
      singleQuoteAttribute ^^ {case singleQuoteAttribute(attr, value) => Attribute(None, attr, Text(value), Null)} |
      doubleQuoteAttribute ^^ {case doubleQuoteAttribute(attr, value) => Attribute(None, attr, Text(value), Null)}
    )

    def emptyNode: Parser[NodeSeq] = (openBracket ~> tag ~ attribute <~ """\s*/\s*>\s*""".r) <~ text ^^ {
      case parsed if parsed._1 == "ident" => parsed._2.foldLeft(<ident/>)(_ % _)
      case _ => NodeSeq.Empty
    }

    def node: Parser[NodeSeq] = (openBracket ~> tag ~ attribute <~ closeBracket) <~ text into { parsed =>
      (rep(item) ^^ { _.foldLeft(NodeSeq.Empty)(_ ++ _) }) <~ ("</" ~ parsed._1 ~ ">") ^^ {
        case entrails if parsed._1 == "ident" => parsed._2.foldLeft(<ident>{entrails}</ident>)(_ % _)
        case _ => NodeSeq.Empty
      }
    }

    val item: Parser[NodeSeq] = emptyNode | node
  }

  val testXml =
    """<ident tag='cloud' s2="s3">hello
      |  <ident></ident>
      |  <root a="r"/>vg
      |  <ident/>gv
      |</ident>""".stripMargin

  val parser = new XmlParser
  val result = parser.parseAll(parser.item, testXml)
  println(result.get)
}
