package exercise

object OOBasicsPrac2 extends App {
  val counterObject = new Counter
  counterObject.increment.increment.currCount
  counterObject.decrement.currCount
  println()
  counterObject.decrement(10).currCount

}

class Counter(val count: Int = 0){

  //println(s"Count reset to $count")
  def currCount = println("Current count is: "+count);

  def increment = {
    println("incremented")
    new Counter(count + 1)
  }
  def decrement={
    println("decremented")
    new Counter(count - 1)
  }

  def increment(n: Int):Counter = {
    if(n<=0) this
    else increment.increment(n-1)
  }

  def decrement(n: Int):Counter= {
    if(n<=0) this
    else decrement.decrement(n-1)
  }
}