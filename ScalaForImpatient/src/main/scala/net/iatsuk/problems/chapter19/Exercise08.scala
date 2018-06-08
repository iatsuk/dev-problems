package net.iatsuk.problems.chapter19

import scala.collection.mutable
import scala.util.parsing.combinator.syntactical.StandardTokenParsers

object Exercise08 extends App {

  class ExprParser extends StandardTokenParsers {

    lexical.delimiters += (";", "=", "+", "-", "*", "(", ")")

    val variables: mutable.HashMap[String, Int] = mutable.HashMap("a" -> 7)

    def assignment: Parser[Any] = rep((ident <~ "=") ~ (expr <~ ";") ^^ (t => t._1 match {
      case "out" => println(t._2)
      case _ => variables += (t._1 -> t._2)
    })) ^^ (_ => ())

    def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term) ^^ (r => r._2.foldLeft(r._1)((acc, t) => t._1 match {
      case "+" => acc + t._2
      case "-" => acc - t._2
    }))

    def term: Parser[Int] = factor ~ rep("*" ~> factor) ^^ (r => r._2.foldLeft(r._1)(_ * _))

    def factor: Parser[Int] = numericLit ^^ (_.toInt) | ident ^^ (variables.getOrElse(_, 0)) | "(" ~> expr <~ ")"

    def parseAll[T](p: Parser[T], in: String): ParseResult[T] = phrase(p)(new lexical.Scanner(in))
  }

  val parser = new ExprParser
  val result = parser.parseAll(parser.assignment, "a = 25; b = 4; out = 76 - a * b;")
}
