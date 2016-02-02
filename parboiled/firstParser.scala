import org.parboiled2._

case class Definitions(statement: String)

class firstParser (val input : ParserInput) extends Parser {
    def parseA = rule { capture(oneOrMore(CharPredicate.Digit)) }
    def parseB = rule { 'a' ~ 'b' ~ "c" }
    def parseC: Rule1[Int] = rule { capture("3") ~> ((_: String).toInt) }

    def parseD = rule { "Def" ~ ": " ~ statement ~ EOI }
    def statement: Rule1[Definitions] = rule { capture(oneOrMore(ANY)) ~>
                                          ((s: String) => Definitions(s))}

    def parseE = rule {CharPredicate.LowerAlpha}
}

object Hi {
    def main(args: Array[String]) = {
        println("Hi..parsing is ready!")
        println(new firstParser("6v886").parseA.run())
        println(new firstParser("23c5").parseA.run())
        println(new firstParser("abc").parseB.run())
        println(new firstParser("3").parseC.run())
        println(new firstParser("Def: aloo is bhanta").parseD.run())
        println(new firstParser("c").parseE.run())
    }
}
