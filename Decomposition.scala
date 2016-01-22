// object oriented decomposition 

trait Expr {
  def isNum : Boolean
  def isSum : Boolean
  def leftOp : Expr
  def rightOp : Expr
  def eval : Int
  def show : String
}

class Num(val n: Int) extends Expr {
  def isNum : Boolean = true
  def isSum : Boolean = false
  def leftOp : Expr = throw new Error("Num.leftOp")
  def rightOp : Expr = throw new Error("Num.rightOp")
  def eval : Int = n
  def show : String = n.toString()
}

class Sum(val e1: Expr, val e2: Expr) extends Expr {
  def isNum : Boolean = false
  def isSum : Boolean = true
  def leftOp : Expr = e1
  def rightOp : Expr = e2
  def eval : Int = e1.eval + e2.eval
  def show : String = "(" + e1.show + "+" + e2.show + ")"
}

object decomp{
  def main(args: Array[String]): Unit = {
    val a = new Sum(new Num(3), new Sum(new Num(4), new Num(6)))
    println(a.show)
    println(a.isNum, a.isSum, a.leftOp, a.rightOp)
    println(a.eval)
  }
}
