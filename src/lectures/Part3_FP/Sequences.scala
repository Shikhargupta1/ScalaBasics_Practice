package lectures.Part3_FP

import scala.util.Random

object Sequences extends App {
  val aSequence = Seq(1,2,3,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))

  println(aSequence ++ Seq(5,6,7))
  println((aSequence ++ Seq(5,8,6,7,10,1,9)).sorted)

  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(x => print(x + "-"))

  val aRangeUntil = 1 until 10
  aRangeUntil.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  //List
  val aList = List(1,2,3,4)
  val append_Prepend = 0 +: aList :+ 5
  println(append_Prepend)

  val apples5 = List.fill(5)("Apple")
  println(apples5)

  println(aList.mkString(" | "))

  val nums = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3)
  threeElements.foreach(println)

  //Mutable
  nums(2) = 0     //syntax sugar for number.update(2,0)
  println(nums.mkString(" _ "))

  //Arrays and sequence
  val numSeq: Seq[Int]= nums    //implicit conversions
  println(numSeq)

  val vector: Vector[Int] = Vector(1,2,3,4,5,6)
  println(vector)

  //Vectors vs lists

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for{
      it <- 1 to 1000
    }yield {
      val iTime = System.nanoTime()
      collection.updated(r.nextInt(1000000), 0)
      System.nanoTime() - iTime
    }

    times.sum / 1000
  }

  val numsList = (1 to 1000000).toList
  val numsVector = (1 to 1000000).toVector

  println(getWriteTime(numsList))
  println(getWriteTime(numsVector))
  println(getWriteTime(numsList)/getWriteTime(numsVector))

}
