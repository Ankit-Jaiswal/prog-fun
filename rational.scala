class Rational (x: Int, y: Int) {
  val numer = x
  val denom = y

  def this(x: Int) = this(x,1) /* first "this" is being defined here and can be used as constructors,
  second "this" is the native inbuilt constructor for class Rational,
  see "more on rational" lecture of odersky */

  def add (that: Rational) = new Rational ((numer*that.denom + denom*that.numer), denom*that.denom)

  def makeString = numer + "/" + denom
}

object rational {
  def main(args: Array[String]): Unit = {
    val a = new Rational(1,2)
    val b = new Rational(2,3)
    val c = new Rational(5)
    println(a.add(b).makeString)
    println(c.makeString)
  }
}
