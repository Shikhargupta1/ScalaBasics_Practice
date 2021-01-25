package lectures.part2_OOps

object Exceptions extends App {

  val x: String = null
  //println(x.length)

  //1. throwing exceptions
  //val aWeirdVal = throw new NullPointerException

  //2. How to catch Exceptions
  def getInt(withExceptions: Boolean):Int = {
    if(withExceptions) throw new RuntimeException
    else 100
  }

  val potentialFail = try{
    getInt(true)
  }catch {
    case e: RuntimeException => 50//println(s"Oops, looks like we have got a ${e.getMessage}")
  }finally {
    //Code that will get executed no matter what
    //Optional
    //does not influence the return type of this expression
    //use finally only for side effects
    println("I am from Finally")
  }

  //3. How to define your own exceptions
  class MyException extends Exception
  val excep = new MyException

  //throw excep

  //Exercises

  var i:Int = 1000

  try{
    def SOException(n: Int):Int = n + SOException(n+1)
    println(SOException(1))
  }catch{
    case e: StackOverflowError => println("Caught SOException")
  }

  try{
    val arr = Array.ofDim(Int.MaxValue)
  }catch{
    case e: OutOfMemoryError => println("Caught OOM Exception")
  }

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division By Zero")

  println(Int.MaxValue, Int.MinValue)
  class PocketCalculator{
    def add(x: Int,y: Int) = {
      if(x>0 && y>0 && x+y < 0) throw new OverflowException
      else if(x<0 && y<0 && x+y > 0) throw new UnderflowException
      else x+y
    }
    def sub(x: Int,y: Int) = {
      if(x<0 && y>0 && x-y > 0) throw new UnderflowException
      else if(x>0 && y<0 && x-y < 0) throw new OverflowException
      else x-y
    }
    def mul(x: Int,y: Int) = {
      if(x>0 && y>0 && x*y < 0 || x<0 && y<0 && x*y < 0) throw new OverflowException
      else if(x>0 && y<0 && x*y > 0 || x<0 && y>0 && x*y > 0) throw new UnderflowException
      else x*y
    }
    def div(x: Int,y: Int) = if(y == 0) throw new MathCalculationException else x/y
  }

  val testPocketCalc = new PocketCalculator
  try{
    //println(testPocketCalc.add(Int.MaxValue, 1))
    //println(testPocketCalc.sub(1,Int.MinValue))
    println(testPocketCalc.mul(Int.MinValue,Int.MinValue))
    //println(testPocketCalc.div(1,0))

  }catch{
    case e1: OverflowException => println(e1.getClass)
    case e2: UnderflowException => println(e2.getClass)
    case e3: MathCalculationException => println(e3.getClass)
  }

}
