package net.iatsuk.problems.chapter19

import scala.collection.mutable
import scala.util.parsing.combinator.syntactical.StandardTokenParsers

object Exercise09 extends App {

  class ExprParser extends StandardTokenParsers {

    lexical.delimiters += ("{", "}", "<", ";", "=", "+", "-", "*", "(", ")")
    lexical.reserved += ("while", "if", "else")

    val variables: mutable.HashMap[String, Int] = mutable.HashMap()

    def algorithm: Parser[Any] = rep1(loop | branch | condition)

    def loop: Parser[Any] = (keyword("while") ~ "(") ~> (condition <~ ")") ~ ("{" ~> assignment <~ "}") ^^ (t => while (t._1) t._2)

    def branch: Parser[Any] = (keyword("if") ~ "(") ~> (condition <~ ")") ~ ("{" ~> assignment <~ "}") ~
      opt(keyword("else") ~> ("{" ~> assignment <~ "}")) ^^ { parsed => if (parsed._1._1) parsed._1._2 else if (parsed._2.isDefined) parsed._2.get }

    def condition: Parser[Boolean] = (factor <~ "<") ~ factor ^^ (t => t._1 < t._2)

    def assignment: Parser[Any] = rep((ident <~ "=") ~ (expr <~ ";") ^^ (t => t._1 match {
      case "out" => println(t._2)
      case _ => variables += (t._1 -> t._2)
    }))

    // TODO: assignment and condition parse to tree and and execute method

    def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term) ^^ (r => r._2.foldLeft(r._1)((acc, t) => t._1 match {
      case "+" => acc + t._2
      case "-" => acc - t._2
    }))

    def term: Parser[Int] = factor ~ rep("*" ~> factor) ^^ (r => r._2.foldLeft(r._1)(_ * _))

    def factor: Parser[Int] = numericLit ^^ (_.toInt) | ident ^^ (variables.getOrElse(_, 0)) | "(" ~> expr <~ ")"

    def parseAll[T](p: Parser[T], in: String): ParseResult[T] = phrase(p)(new lexical.Scanner(in))
  }

  val parser = new ExprParser
  val result = parser.parseAll(parser.condition, "4 < 3")
  if (result.successful) println(result.get)
}
