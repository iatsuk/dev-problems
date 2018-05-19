package net.iatsuk.problems.chapter19

import scala.util.parsing.combinator.RegexParsers

object Exercise01 extends App {

  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r

    def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term ^^ {case "+" ~ t => t; case "-" ~ t => -t}) ^^ {
      case t ~ r => t + r.sum
    }

    def term: Parser[Int] = factor ~ rep(("*" | "/" | "%") ~ factor) ^^ {
      case f ~ Nil => f
      case f ~ r => r.foldLeft(f){
        case (a, ~ ("*", b)) => a * b
        case (a, ~ ("/", b)) => a / b
        case (a, ~ ("%", b)) => a % b
      }
    }

    def factor: Parser[Int] = number ^^ (_.toInt) | "(" ~> expr <~ ")"
  }

  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "(3-4-4*5*6)/11+(11%10)")
  if (result.successful) println(result.get)
}
