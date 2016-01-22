abstract class Natural

case object Zero extends Natural
case class Successor(x: Natural) extends Natural

object natural {
  def addNatural(x: Natural, y: Natural): Natural = y match {
      case Zero => x
      case Successor(yy) => Successor(addNatural(x,yy))
  }

  def main(args: Array[String]): Unit = {
    println(addNatural(Successor(Zero), Successor(Zero)))
  }
  
}
