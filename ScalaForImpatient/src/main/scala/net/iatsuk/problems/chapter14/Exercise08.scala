package net.iatsuk.problems.chapter14

object Exercise08 extends App {

  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(operator: Char, leafs: BinaryTree*) extends BinaryTree

  def eval(tree: BinaryTree): Int = tree match {
    case Node(op, leafs@_*) => op match {
      case '+' => leafs.map(eval).sum
      case '-' => -leafs.map(eval).sum
      case '*' => leafs.map(eval).product
      case '/' => leafs.map(eval).reduceLeft(_ / _)
    }
    case l: Leaf => l.value
  }

  val tree = Node('+', Node('*', Leaf(3), Leaf(8)), Leaf(2), Node('-', Leaf(5)))

  println(eval(tree))
}
