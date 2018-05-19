package net.iatsuk.problems.chapter19

import java.util.Date

import scala.util.parsing.combinator.RegexParsers

object Exercise04 extends App {

  class ExprParser extends RegexParsers {
    private val date = """(\d{4})-(\d{2})-(\d{2})T(\d{2}):(\d{2})""".r

    def datetime: Parser[Date] = date ^^ {
      case date(yyyy, mm, dd, h, m) => new Date(yyyy.toInt - 1900, mm.toInt - 1, dd.toInt, h.toInt, m.toInt)
    }
  }

  val parser = new ExprParser
  val result = parser.parseAll(parser.datetime, "1989-10-31T07:35")
  if (result.successful) println(result.get)
}
