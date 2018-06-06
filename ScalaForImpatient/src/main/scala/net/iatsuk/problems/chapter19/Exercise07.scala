package net.iatsuk.problems.chapter19

import scala.util.parsing.combinator.RegexParsers

object Exercise07 extends App {

  class ExprParser extends RegexParsers {
    private val number = "[0-9]+".r

    def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term) ^^ (r => r._2.foldLeft(r._1)((acc, t) => t._1 match {
      case "+" => acc + t._2
      case "-" => acc - t._2
    }))

    def term: Parser[Int] = factor ~ rep("*" ~> factor) ^^ (r => r._2.foldLeft(r._1)(_ * _))

    def factor: Parser[Int] = number ^^ (_.toInt) | "(" ~> expr <~ ")"
  }

  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "3-4-5*5")
  if (result.successful) println(result.get)
}
