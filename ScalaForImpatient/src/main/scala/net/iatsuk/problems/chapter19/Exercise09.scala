package net.iatsuk.problems.chapter19

import scala.collection.mutable
import scala.util.parsing.combinator.syntactical.StandardTokenParsers

object Exercise09 extends App {

  class ExprParser extends StandardTokenParsers {

    sealed trait Tree {
      def execute(): Any
    }

    case class Block(blocks: List[Tree]) extends Tree {
      override def execute(): Any = blocks.foreach(_.execute())
    }

    case class Loop(condition: Tree, block: Tree) extends Tree {
      override def execute(): Unit = while (condition.execute().asInstanceOf[Boolean]) block.execute()
    }

    case class Branch(condition: Tree, onTrue: Tree, onFalse: Tree) extends Tree {
      override def execute(): Any = if (condition.execute().asInstanceOf[Boolean]) onTrue.execute() else onFalse.execute()
    }

    case class Operator(op: String, left: Any, right: Any) extends Tree {
      override def execute(): Any = op match {
        case "+" => left.asInstanceOf[Tree].execute().asInstanceOf[Int] + right.asInstanceOf[Tree].execute().asInstanceOf[Int]
        case "-" => left.asInstanceOf[Tree].execute().asInstanceOf[Int] - right.asInstanceOf[Tree].execute().asInstanceOf[Int]
        case "*" => left.asInstanceOf[Tree].execute().asInstanceOf[Int] * right.asInstanceOf[Tree].execute().asInstanceOf[Int]
        case "/" => left.asInstanceOf[Tree].execute().asInstanceOf[Int] / right.asInstanceOf[Tree].execute().asInstanceOf[Int]
        case "%" => left.asInstanceOf[Tree].execute().asInstanceOf[Int] % right.asInstanceOf[Tree].execute().asInstanceOf[Int]
        case "<" => left.asInstanceOf[Tree].execute().asInstanceOf[Int] < right.asInstanceOf[Tree].execute().asInstanceOf[Int]
        case ">" => left.asInstanceOf[Tree].execute().asInstanceOf[Int] > right.asInstanceOf[Tree].execute().asInstanceOf[Int]
        case "<=" => left.asInstanceOf[Tree].execute().asInstanceOf[Int] <= right.asInstanceOf[Tree].execute().asInstanceOf[Int]
        case ">=" => left.asInstanceOf[Tree].execute().asInstanceOf[Int] >= right.asInstanceOf[Tree].execute().asInstanceOf[Int]
        case "==" => left.asInstanceOf[Tree].execute().asInstanceOf[Int] == right.asInstanceOf[Tree].execute().asInstanceOf[Int]
        case "!=" => left.asInstanceOf[Tree].execute().asInstanceOf[Int] != right.asInstanceOf[Tree].execute().asInstanceOf[Int]
        case "=" => left match {
          case "out" => println(right.asInstanceOf[Tree].execute())
          case name: String => variables(name) = right.asInstanceOf[Tree].execute().asInstanceOf[Int]
        }
      }
    }

    case class Number(value: Any) extends Tree {
      override def execute(): Any = value match {
        case i: Int => i
        case v: String => variables.getOrElse(v, 0)
        case _ => Unit
      }
    }

    lexical.delimiters += ("{", "}", "<", ">", "<=", ">=", "==", "!=", ";", "=", "+", "-", "*", "/", "%", "(", ")")
    lexical.reserved += ("while", "if", "else")

    val variables: mutable.HashMap[String, Int] = mutable.HashMap()

    def alg: Parser[Tree] = loop | branch | (assignment <~ ";") | ("{" ~> rep1(alg) <~ "}") ^^ Block

    def loop: Parser[Tree] = ("while" ~ "(") ~> (cond <~ ")") ~ alg ^^ (t => Loop(t._1, t._2))

    def branch: Parser[Tree] = ("if" ~ "(") ~> (cond <~ ")") ~ alg ~ opt(keyword("else") ~> alg) ^^ { t => Branch(t._1._1, t._1._2, t._2.getOrElse(Number(null))) }

    def assignment: Parser[Tree] = (ident <~ "=") ~ expr ^^ (t => Operator("=", t._1, t._2))

    def cond: Parser[Tree] = expr ~ ("<" | ">" | "<=" | ">=" | "==" | "!=") ~ expr ^^ (t => Operator(t._1._2, t._1._1, t._2))

    def expr: Parser[Tree] = term ~ rep(("+" | "-") ~ term) ^^ (t => t._2.foldLeft(t._1)((acc, p) => Operator(p._1, acc, p._2)))

    def term: Parser[Tree] = factor ~ rep(("*" | "/" | "%") ~ factor) ^^ (t => t._2.foldLeft(t._1)((acc, p) => Operator(p._1, acc, p._2)))

    def factor: Parser[Tree] = numericLit ^^ (n => Number(n.toInt)) | ident ^^ (Number(_)) | "(" ~> expr <~ ")"

    def parseAll[T](p: Parser[T], in: String): ParseResult[T] = phrase(p)(new lexical.Scanner(in))
  }

  val parser = new ExprParser
  val code =
    """{
      |  while (b < 4) b = b + 1;
      |  out = b;
      |  if (b != 4)
      |    a = 25;
      |  else {
      |    a = b * 10;
      |    a = a / 2;
      |  }
      |  out = a;
      |  out = 76 - a * b;
      |}""".stripMargin
  val result = parser.parseAll(parser.alg, code)
  if (result.successful) result.get.execute()
}
