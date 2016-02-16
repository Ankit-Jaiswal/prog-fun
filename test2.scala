import scala.io.Source

object test2 {
	val a = 24

	def main(args: Array[String]): Unit = {
	  val a = myclass(3)
		println(a.input)
		//println("your input is:" + args(0))


		val filelines = Source.fromFile("hello.txt").getLines.toList
		println(filelines)
	}
}

object succ {
	val b = 2+2
	println(b)
}

case class myclass(input : Int)

//recurrsive def
trait mytrait
case object myobject extends mytrait
case class subtrait1(again: mytrait) extends mytrait

//println(new myclass(3).myFuc())
