package lectures.part1Basics

object Functions extends App {

  def aFunction(a: String ,b: Int): String= {
    a + "" +b
  }
  println(aFunction("Obscurial",9))

  def aParameterLessFunction(): Int = 42
  println(aParameterLessFunction())
  //OR
  //println(aParameterLessFunction)

  def aRepeatedFunction(word: String, count: Int): String={
    if (count == 1) word
    else word + aRepeatedFunction(word,count-1)
  }
  println(aRepeatedFunction("I am Groot ",4))

  def aSideEffectFunction(aString : String): Unit = println("Gabba")

  def aBigFunc(n: Int)={
    def aSmallFunc(a: Int, b:Int): Int= a + b

    aSmallFunc(n,n-1)
  }

  println(aBigFunc(10))


}
