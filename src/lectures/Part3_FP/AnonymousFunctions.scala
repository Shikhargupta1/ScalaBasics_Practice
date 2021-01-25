package lectures.Part3_FP

object AnonymousFunctions extends App {

  //Anonymous Lambda
  val doubler: Int => Int = x => x*2
  println(doubler(2))

  val adder: (Int,Int) => Int = (x,y) => x + y
  println(adder(1,2))

  val justDoSomething: () => Int = () => 100
  println(justDoSomething())  // this is DIFFERENT from below
  println(justDoSomething)    // prints class name

  val stringToInt= {  (str: String) =>
    str.toInt
  }
  println(stringToInt("200"))

  // More Syntactic Sugar

  val niceIncrementer: Int=>Int = _+1
  val niceAdder: (Int,Int)=>Int = _ + _

  val niceHOF = (x: Int) => (y :Int) => x + y
  println(niceHOF(5)(10))

}
