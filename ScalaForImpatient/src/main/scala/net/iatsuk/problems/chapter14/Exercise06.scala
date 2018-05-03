package net.iatsuk.problems.chapter14

object Exercise06 extends App {

  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

  def leafSum(tree: BinaryTree): Int = tree match {
    case n: Node => leafSum(n.left) + leafSum(n.right)
    case l: Leaf => l.value
  }

  val tree = Node(Node(Leaf(3), Leaf(8)), Leaf(2))

  println(leafSum(tree))
}
