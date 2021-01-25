package exercise

abstract class Maybe[+T]{
  /*def head: T
  def isEmpty: Boolean
  def changeVal[B](value: B): Maybe[B]
  def getVal: String*/
  def filter(predicate: T => Boolean): Maybe[T]
  def map[B](f: T => B): Maybe[B]
  def flatMap[B](f: T => Maybe[B]): Maybe[B]

}

case object MaybeNot extends Maybe[Nothing]{
  /*def head: Nothing = throw new NoSuchFieldException()
  def isEmpty: Boolean = true
  def changeVal[B](value: B): Maybe[B] = Just[B](value)
  def getVal: String = ""+()*/
  def filter(predicate: Nothing => Boolean): Maybe[Nothing] = MaybeNot
  def map[B](f: Nothing => B): Maybe[B] = MaybeNot
  def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot
}

case class Just[+T](value: T) extends Maybe[T]{
  /*def head: T = value
  def isEmpty: Boolean = false
  def changeVal[B](v: B): Maybe[B] = Just(v)
  def getVal: String = "" + value*/
  def filter(predicate: T => Boolean): Maybe[T] =
    if(predicate(value)) this
    else MaybeNot

  def map[B](f: T => B): Maybe[B] = Just(f(value))
  def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)
}

object MaybeTest extends App{
  val Just100 = Just[Int](100)
  val aChar = Just[Char]('a')
  println(Just100)
  println(Just100.filter(_ % 2 != 0))
  println(Just100.map(_ + "-Num"))
  println(Just100.flatMap(x => Just(x%2 != 0)))

  val combine = for {
    n <- Just100
    c <- aChar
  } yield ""+n+"-"+c
  println(combine)

}


