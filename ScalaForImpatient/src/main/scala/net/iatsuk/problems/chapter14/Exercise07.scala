package net.iatsuk.problems.chapter14

object Exercise07 extends App {

  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(leafs: BinaryTree*) extends BinaryTree

  def leafSum(tree: BinaryTree): Int = tree match {
    case n: Node => n.leafs.map(leafSum).sum
    case l: Leaf => l.value
  }

  val tree = Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))

  println(leafSum(tree))
}
