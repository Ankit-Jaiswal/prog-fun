import org.parboiled2._

import MyGrammar._

///////////////        PARSER      ////////////////


class Read(val input: ParserInput) extends Parser {
  def InputLine = rule {EqParser ~ EOI}

  def EqParser: Rule1[Equation] = rule { (ExprParser ~ '=' ~ ConstParser) ~>
                                    ((e: Expr,c: Constant) => Equation(e,c)) }

  def ConstParser: Rule1[Constant] = rule {
                    capture(oneOrMore(CharPredicate.Digit)) ~>
                    ((s: String) => Constant(s))
                  }

  def VarParser: Rule1[Variable] = rule { capture(CharPredicate.LowerAlpha) ~>
                                          ((s: String) => Variable(s)) }


  def ExprParser: Rule1[Expr] = rule {
                    TermParser ~ zeroOrMore(
                      '+' ~ TermParser ~> ((e1: Expr,e2: Expr) => Sum(e1,e2))
                      | '-' ~ TermParser ~> ((e1: Expr,e2: Expr) => Diff(e1,e2))
                      )
                    }

  def TermParser: Rule1[Expr] = rule {
                    FactorParser ~ zeroOrMore(
                      '*' ~ FactorParser ~> ((e1: Expr, e2: Expr) => Prod(e1,e2))
                    )
                  }

  def FactorParser: Rule1[Expr] = rule { ConstParser | VarParser | ParenParser }

  def ParenParser = rule { '(' ~ ExprParser ~ ')' }
}

object MyParser {
  def main(args: Array[String]): Unit = {
    println(new Read("2*x+3=4").InputLine.run())
  }
}
