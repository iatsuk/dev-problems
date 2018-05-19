package net.iatsuk.problems.chapter19

import scala.util.parsing.combinator.RegexParsers

object Exercise02 extends App {

  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r

    def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term ^^ {case "+" ~ t => t; case "-" ~ t => -t}) ^^ {
      case t ~ r => t + r.sum
    }

    def term: Parser[Int] = pow ~ rep(("*" | "/" | "%") ~ pow) ^^ {
      case f ~ Nil => f
      case f ~ r => r.foldLeft(f){
        case (a, ~ ("*", b)) => a * b
        case (a, ~ ("/", b)) => a / b
        case (a, ~ ("%", b)) => a % b
      }
    }

    def pow: Parser[Int] = factor ~ rep("^" ~> factor) ^^ {
      case f ~ Nil => f
      case f ~ r => math.pow(f, r.reduceRight(math.pow(_,_).toInt)).toInt
    }

    def factor: Parser[Int] = number ^^ (_.toInt) | "(" ~> expr <~ ")"
  }

  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "4^2^3")
  if (result.successful) println(result.get)
}
