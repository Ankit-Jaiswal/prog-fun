import org.parboiled2._

class myParser (val input : ParserInput) extends Parser {
    def parseA = rule { capture(oneOrMore(CharPredicate.Digit)) }
}

object Hello {
    def main(args: Array[String]) = {
        println("Hi..parsing is ready!")
        println(new myParser("6v886").parseA.run())
        println(new myParser("23c5").parseA.run())
    }
}
