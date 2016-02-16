abstract class Node
case class Terminal(val value: Int) extends Node
case class NonTerminal(val value: Int, val xs: List[Node]) extends Node

object TreeTraversal {

  def countLeafs(tree: Node): List[Int] = tree match {
    case Terminal(_) => List(1)
    case NonTerminal(_, xs) => xs.flatMap(x => countLeafs(x))
  }

  def sum(xs: List[Int]): Int = xs match {
    case x :: tail => x + sum(tail)
    case Nil => 0
  }

  def main(args: Array[String]): Unit = {
    val treeA = NonTerminal(3, List(Terminal(2), NonTerminal(4, List(Terminal(5), NonTerminal(6, List(Terminal(8))), Terminal(7)))))
    println(sum(countLeafs(treeA)))
  }

}
