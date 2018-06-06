package net.iatsuk.problems.chapter19

import scala.util.parsing.combinator.RegexParsers

object Exercise06 extends App {

  sealed trait Expr
  case class Number(value: Int) extends Expr
  case class Operator(op: String, left: Expr, right: Expr) extends Expr

  class ExprParser extends RegexParsers {
    private val number = "[0-9]+".r

    def expr: Parser[Expr] = term ~ rep(("+" | "-") ~ term) ^^ (r => r._2.foldLeft(r._1)((acc, t) => Operator(t._1, acc, t._2)))

    def term: Parser[Expr] = factor ~ rep("*" ~> factor) ^^ (r => r._2.foldLeft(r._1)(Operator("*", _, _)))

    def factor: Parser[Expr] = number ^^ (n => Number(n.toInt)) | "(" ~> expr <~ ")"
  }

  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "3-4-5*5")
  if (result.successful) println(result.get)
}
