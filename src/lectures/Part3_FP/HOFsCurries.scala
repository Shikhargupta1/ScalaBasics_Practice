package lectures.Part3_FP

object HOFsCurries extends App {

  // HOF --> Higher Order Functions
  // Function that applies another function n times over a value x
  // nTimes(f,n,x)
  // nTimes(f,3,x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  // nTimes(f,n,x) = f(f(.....f(x))) = nTimes(f, n-1, f(x))

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if(n<=0) x
    else nTimes(f,n-1,f(x))
  }

  val plusOne = (x: Int) => x+1
  println(nTimes(plusOne,10,0))

  //nbt(f,n) = x => f(f(.......f(x)))
  //inc10 = nbt(plusOne,10) = plusOne(plusOne......(x))
  //val y = inc10(0)
  def nTimesBetter(f: Int => Int, n: Int): Int => Int =
    if(n<=0) (x:Int) => x
    else (x:Int) => nTimesBetter(f,n-1)(f(x))

  val inc10 = nTimesBetter(plusOne,10)
  println(inc10(0))

  //curried function
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  val add10 = superAdder(10)
  println(add3(10))
  println(add10(10))

  def curriedFormatter(c: String)(x: Double) = c.format(x)

  val standardFormatter: Double => String = curriedFormatter("%1.2f")
  val preciseFormatter: Double => String = curriedFormatter("%1.8f")


  println(standardFormatter(Math.E))
  println(preciseFormatter(Math.E))

  def toCurries(f: (Int,Int) => Int): (Int => Int => Int) = {
    x => y => f(x,y)
  }

  val adder = (x: Int,y: Int) => x+y
  println(toCurries(adder)(10)(1))

  val superAdder2: (Int => Int => Int) = toCurries(_+_)
  val add4 = superAdder2(4)
  println(add4(10))

  val simpleAdder = fromCurry(superAdder2)
  println(simpleAdder(10,11))

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
    (x,y) => f(x)(y)

  def compose[A,B,T](f: A => B, g: T => A): T => B =
    x => f(g(x))

  def andThen[A,B,T](f: A => B, g: B => T): A => T=
    x => g(f(x))

  val add2 = (x:Int) => x + 2
  val times3 = (x:Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println(composed(10))
  println(ordered(10))

}
