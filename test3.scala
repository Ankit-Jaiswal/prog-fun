abstract class absclass {
  def f1 : Int
  def f2 : Boolean
}

case class myclass2 (val f1: Int) extends absclass {
  def f2 = true
}

object test3 {
  def main(args: Array[String]): Unit = {
    val a: absclass = myclass2(5)

    println(a.f1, a.f2)
  }

}
