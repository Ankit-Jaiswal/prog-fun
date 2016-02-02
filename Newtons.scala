
object Newtons {
  def abs(x: Double) : Double = {
      if (x > 0) x
      else -x
  }

  def isGoodEnough(x: Double, guess: Double) : Boolean = abs(guess*guess - x) < 0.02

  def improve(x: Double, y: Double) : Double = (y + x/y)/2

  def sqrt(x: Double, guess: Double) : Double = {
      if (isGoodEnough(x,guess)) guess
      else sqrt(x,improve(x,guess))
  }

  def main(args: Array[String]): Unit = {
    println(sqrt(2.0,1.1))
  }
}
