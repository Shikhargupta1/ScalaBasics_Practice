package lectures.part1Basics

object CbV_vs_CbN extends App{

  def callByValue(n: Long)={
    println("CbV: " + n)                // OR println("CbV: " + 70907949368600)
    println("CbV: " + n)
  }

  def callByName(n: => Long)={
    println("CbN: " + n)                // OR println("CbN: " + System.nanoTime())
    println("CbN: " + n)
  }

  callByValue(System.nanoTime())        // This is same as passing a constant value like **** callByName(70907949368600)
  callByName(System.nanoTime())         // While this equates to **** callByName(System.nanoTime())

  // Some more mundane examples

  def infinite():Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //println(printFirst(infinite(),50))    // Results in -- Exception in thread "main" java.lang.StackOverflowError
  printFirst(50,infinite())               // However this does not even call infinite(), as it is never used

}
