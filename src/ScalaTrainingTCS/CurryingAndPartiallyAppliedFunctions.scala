package ScalaTrainingTCS

object CurryingAndPartiallyAppliedFunctions extends App{
  def n_divides_m(m: Int,n: Int) = m%n == 0

  def isEven(x: Int) = n_divides_m(x,2)
  def isOdd(x: Int) = !n_divides_m(x,2)

  println(isEven(12345))
  println(isOdd(12345))
}
