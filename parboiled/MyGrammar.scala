object MyGrammar {

  case class Equation(exp: Expr, const: Constant)

  trait Expr

  case class Constant(name: String) extends Expr
  case class Variable(name: String) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Diff(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

}
