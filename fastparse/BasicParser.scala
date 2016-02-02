import fastparse.all._

object basicparser {
  def main(args: Array[String]) = {
		val parseA = P( "ab" )
		println(parseA.parse("ab"))
		println(parseA.parse("abb"))
	}
}
