import org.parboiled2._

case class Definitions(statement: String)

class ParserClass (val input : ParserInput) extends Parser {
  def parseA = rule { capture(oneOrMore(CharPredicate.Digit)) }
  def parseB = rule { zeroOrMore('a') ~ 'b' ~ "c" }
  def parseC: Rule1[Int] = rule { capture("3") ~> ((_: String).toInt) }

  def parseD = rule { "Def" ~ ": " ~ statement ~ EOI }
  def statement: Rule1[Definitions] = rule { capture(oneOrMore(ANY)) ~>
                                          ((s: String) => Definitions(s))}

  def parseE = rule {CharPredicate.LowerAlpha}
  def day = rule {"Monday" | "Tuesday" | "Wednesday" | "Thursday" }

  def newlines = rule { zeroOrMore('\n') }
  def ws = rule { oneOrMore(" " | '\t') }

  def week = rule { "Mon" ~ newlines ~ "Tue" ~ newlines ~ "Wed" ~ newlines }

  def parseF = rule { CharPredicate.Alpha ++ '*' }

  def parseG = rule { "b" ~ "c" | "b" ~ optional("d") }
}

object firstParser {

  val a = "Mon	Tue		Wed"

  val b = scala.io.Source.fromFile("weekdays.txt").getLines mkString "\n"

  def main(args: Array[String]) = {
    println("Hi..parsing is ready!")
    println(new ParserClass("6v886").parseA.run())
    println(new ParserClass("23c5").parseA.run())
    println(new ParserClass("bc").parseB.run())
    println(new ParserClass("3").parseC.run())
    println(new ParserClass("Def: aloo is bhanta").parseD.run())
    println(new ParserClass("c").parseE.run())
    println(new ParserClass("Thursday").day.run())

    //println(b)
    println(new ParserClass(b).week.run())

    println(new ParserClass("*").parseF.run())
    println(new ParserClass("b").parseG.run())
    }
}
