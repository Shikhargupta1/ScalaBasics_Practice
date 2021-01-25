package exercise

import lectures.part2_OOps.Generics.{MyList, listOfIntergers}

import scala.collection.View.Zip
import scala.runtime.Nothing$

abstract class MyList[+A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](n: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
    def ++[B >: A](list: MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]
  def forEach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyList[A]
  def zipWith[B,C](myList: MyList[B], zip: (A,B) => C): MyList[C]
  def fold[B](start: B)(operator: (B,A) => B): B
}

case object Empty extends MyList[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add[B >: Nothing](n: B): MyList[B] = Cons(n, Empty)
  def printElements: String = ""
  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
    def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty


  //HOF's
  def forEach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
  def zipWith[B, C](myList: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if(!myList.isEmpty) throw new RuntimeException("Lists are not of same size")
    else Empty

  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A]{
  //def this(h: Int) = this(h, Empty)
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](n: B): MyList[B] = Cons(n, this)
  def printElements: String =
    if(t.isEmpty)  "" + h
    else h + " " + tail.printElements

  def map[B](transformer: A => B): MyList[B] =
    new Cons[B](transformer(h), t.map(transformer))

  def ++[B >: A](list: MyList[B]): MyList[B] = Cons(head, t ++ list)
  /*
  * [1,2].flatMap(n => [n,n+1]) = [1,2] ++ [2].flatMap(n => [n,n+1]) = [1,2] ++ [2,3] ++ Empty
  * */
  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  def filter(predicate: A => Boolean): MyList[A] =
    if(predicate(h)) new Cons[A](h, t.filter(predicate))
    else t.filter(predicate)

  def forEach(f: A => Unit): Unit = {
    f(head)
    t.forEach(f)
  }

  def sort(compare: (A,A) => Int): MyList[A] = {

    def insert(a: A, sortedList: MyList[A]): MyList[A] ={
      if(sortedList isEmpty) new Cons(a, Empty)
      else if(compare(a, sortedList.head) >= 0) new Cons(a, sortedList)
      else new Cons(sortedList.head, insert(a, sortedList.tail))
    }
    val sortedTail = t.sort(compare)
    insert(head, sortedTail)
  }

  def zipWith[B, C](newList: MyList[B], zip: (A, B) => C): MyList[C] =
    if(newList isEmpty) throw new RuntimeException("Lists are not of same size")
    else new Cons(zip(head,newList.head), t.zipWith(newList.tail,zip))

  def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start,head))(operator)
  }

}

object ListTest extends App{

  val listOfEmptyIntegers: MyList[Int] = Empty
  val listOfEmptyStrings: MyList[String] = Empty
  val listofInts = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3,Empty)))
  var cloneListofInts = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3,Empty)))
  val listOfStrings = new Cons[String]("Hello", new Cons[String]("World", new Cons[String]("Scala" , Empty)))

  println(listofInts.toString)
  println(listOfStrings.toString)

  val testPredicate = new (Int => Boolean) {
     override def apply(n: Int): Boolean = n%2==0
  }

  val testPredicate1 = new (Int => Boolean) {
    override def apply(n: Int): Boolean = n%2==0
  }
  println(testPredicate1(11))

  val testTransformer = new (String => Int) {
    override def apply(x: String): Int = Integer.parseInt(x)
  }

  println(testTransformer("100"))

  println(listofInts ++ listofInts)

  println(listofInts.map(_ * 2))
  println(listofInts.filter(_%2 == 0))
  println(listofInts.flatMap((x: Int) => Cons(x, Cons(x + 1, Empty))).toString)

  println(cloneListofInts == listofInts)

  listofInts.forEach(x => print(x+" "))
  println()
  println(listofInts.sort((x,y) => x-y))

  println(cloneListofInts.zipWith[String,String](listOfStrings, _+"-"+_))
  println(listofInts.fold(10)(_*_))

  val combos = for {
    n <- listofInts
    s <- listOfStrings
  }yield ""+ n + "-" + s

  println(combos)

}