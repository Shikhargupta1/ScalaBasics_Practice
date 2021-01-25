package lectures.Part3_FP

object WhatsAFunction extends App {

  //DREAM: Use functions as first class elements, i.e. define everything in terms of Functions
  //Problem : We work on OOP based JVM

  val doubler = new MyFunction[Int,Int] {
    override def apply(x: Int): Int = x*2
  }
  println(doubler(5))

  //Function types => Function1[A,B]

  val stringToIntConverter = new Function1[String,Int] {
    override def apply(v1: String): Int = v1.toInt
  }
  println(stringToIntConverter("100")+ 50)

  val sumOfTwoNums: Function2[Int,Int,String] = new Function2[Int,Int,String] {
    override def apply(v1: Int, v2: Int): String = "" + (v1 + v2)
  }
  println(sumOfTwoNums(2,3))

  // Exercise

  //Function1[Int, Function1[Int]]
  val higherOrderFunction: Function[Int, Int => Int] = (x: Int) => new Function[Int, Int] {
    override def apply(y: Int): Int = x + y
  }

  // Equals to above function
  val higherOrderFunction1 = (x: Int) => (y: Int) => x + y


  val testHof = higherOrderFunction1(10)
  println(testHof(11))
  // Equals Below
  println(higherOrderFunction1(10)(11))
}

//All Scala Functions are objects

trait MyFunction[A,B]{
  def apply(x: A):B
}

