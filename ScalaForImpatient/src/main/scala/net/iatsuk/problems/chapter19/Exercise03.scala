package net.iatsuk.problems.chapter19

import scala.util.parsing.combinator.RegexParsers

object Exercise03 extends App {


  class ExprParser extends RegexParsers {
    val number = "-?[0-9]+".r

    def array: Parser[List[Int]] = "(" ~> repsep(number, ",") <~ ")" ^^ (_.map(_.toInt))
  }

  val parser = new ExprParser
  val result = parser.parseAll(parser.array, "(1, 23, -79)")
  if (result.successful) println(result.get)
}
