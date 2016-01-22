// decomposition using pattern matching.

trait Exp {
  def eval : Int = this match {
    case CaseNum(n) => n
    case CaseSum(e1, e2) => e1.eval + e2.eval
  }

  def show : String = this match {
    case CaseNum(n) => n.toString()
    case CaseSum(e1, e2) => e1.show + "+" + e2.show
  }

}

case class CaseNum(val n: Int) extends Exp

case class CaseSum(val e1: Exp, val e2: Exp) extends Exp

//case class Var(val x: Char) extends Exp
