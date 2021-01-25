package lectures.part1Basics

import scala.annotation.tailrec

object Recursion extends App {

  // Dealing with StackOverFlow issue using tail Recursion
  def afactorial(n : BigInt): BigInt={
    @tailrec
    def innerFact(n: BigInt, accumulator: BigInt): BigInt={
      if(n<=1) accumulator
      else innerFact(n-1, n*accumulator)
    }
    innerFact(n,1)
  }
  println(afactorial(1000))
}

//Refer TailRecursionExercise from Exercise package
