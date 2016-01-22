object curry {

  def prod (f: Int => Int) (a: Int, b: Int) : Int = {
    if (a > b) 1 else f(a) * prod(f)(a+1,b)
  }

  def fact(x: Int) = prod(x => x)(1,x)

  

  def main(args: Array[String]): Unit = {
    println(prod(x => x*x)(1,3))
    println(fact(5))
  }
}
