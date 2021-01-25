package ScalaTrainingTCS

object Closures extends App {
  def variableIncrement(inc: Int) = (x: Int) => x + inc
  def inc1 = variableIncrement(1)
  println(inc1(20))

  def inc10 = variableIncrement(10)
  println(inc10(1))

}
