package exercise

import scala.annotation.tailrec

object TailRecursionExercise extends App {

  /*
  def anotherConcatSameString(word:String , n: BigInt): String={
    @tailrec
    def innerConcat(word1 : String, n:BigInt):String= {
      if(n<=0) word1
      else innerConcat(word1 +" "+ word,n-1)
    }
    innerConcat(word,n)
  }
  */

  def concatTailRecursive(word: String, n: Int): String ={
    @tailrec
    def innerConcat(word: String, n: Int, accumulator: String): String = {
      if(n<=0) accumulator
      else innerConcat(word, n-1, accumulator + " " + word)
    }
    innerConcat(word, n, "")
  }
  //println(concatTailRecursive("My name is  Khan", n = 10000))


  def tailRecCheckIfPrime(n: Int): Boolean={
    @tailrec
    def innerIsPrime(i: Int, isStillPrime: Boolean): Boolean={
      if(!isStillPrime) false
      else if(i<=1) true
      else innerIsPrime(i-1, n%i!=0 && isStillPrime)
    }
    innerIsPrime(n/2,true)
  }
  //println(tailRecCheckIfPrime(104729))

  def tailRecFibonacci(n: Int): Int = {
    @tailrec
    def innerFibo(i: Int, last: Int, secondLast: Int):Int= {
      if(i >= n) last
      else innerFibo(i+1,last+secondLast,last)
    }
    if(n<=2) n
    else innerFibo(2,1,1)
  }


}

