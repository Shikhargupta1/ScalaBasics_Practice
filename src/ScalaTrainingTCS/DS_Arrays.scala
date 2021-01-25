package ScalaTrainingTCS

import scala.collection.convert.ImplicitConversions.`seq AsJavaList`

object DS_Arrays extends App {

  //Arrays are MUTABLE

  val greetStrings = new Array[String](3)
  println(greetStrings(0)) // null
  // println(greetStrings(3))  --> Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
  greetStrings(0) = "Hello"
  greetStrings.update(1,"Lad")
  println(greetStrings.foreach(println))

  println(greetStrings.apply(1)) // same as get

  val arr2 = Array.apply("zero","one","two")
  println(arr2.foreach(print))

  val thrill = "Will" :: "fail" :: "until" :: Nil
  println(thrill.foreach(println))

  val joinedArray = List("a","b"):::List("c","d")
  println(joinedArray.foreach(println))

  println(thrill.count(x => x.length <6))

  //println(thrill.drop(2).foreach(println))

  println(thrill.exists(s => s.equals("fail"))) //   OR s => s == "fail"

  // filter, map, endwith, length, isEmpty etc

  println(thrill.head + " " + thrill.last)

  //mkstring -> joins list elements with given parameter
  println(thrill.mkString("-"))

  //filterNot, reverse, sort,
  // tail -> returns all but first element
  // init -> returns all but last element

  //sort , sorted, sortBy, sortWith

}

