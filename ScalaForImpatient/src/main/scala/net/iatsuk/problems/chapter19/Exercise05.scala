package net.iatsuk.problems.chapter19

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

// TODO: not implemented yet
object Exercise05 extends App {

  class XmlParser extends RegexParsers {
    private val tag = "\\w*".r
    private val text: Regex = "[^<>]*".r
    private val singleQuoteAttribute = """\s*(\w*)\s*=\s*'([^<>']*)'\s*""".r
    private val doubleQuoteAttribute = """\s*(\w*)\s*=\s*"([^<>"]*)"\s*""".r
    private val openBracket = "\\s*<\\s*".r
    private val closeBracket = "\\s*>\\s*".r

    def attribute: Parser[String] = rep(singleQuoteAttribute | doubleQuoteAttribute) ^^ {
      _.foldLeft("")(_ + _)
    }

    def emptyNode: Parser[String] = (openBracket ~> tag ~ attribute <~ "\\s*/>\\s*".r) <~ text ^^ {
      case parsed if parsed._1 == "ident" => s"<${parsed._1} ${parsed._2}/>"
      case _ => ""
    }

    def node: Parser[String] = (openBracket ~> tag ~ attribute <~ closeBracket) <~ text into { parsed =>
      (rep(item) ^^ { _.foldLeft("")(_ + _) }) <~ ("</" ~ parsed._1 ~ ">") ^^ {
        case entrails if parsed._1 == "ident" => s"<${parsed._1} ${parsed._2}>$entrails</${parsed._1}>"
        case _ => ""
      }
    }

    val item: Parser[String] = emptyNode | node
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
