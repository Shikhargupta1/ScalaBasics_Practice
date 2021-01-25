package exercise

import scala.annotation.tailrec

object FunctionsExcercises1 extends App {
  //1. A Greeting func (name,age)

  def myGreetings(name: String, age:Int): String = {
    s"Hi, my name is $name and I am $age year old."
  }
  println(myGreetings("Vishu", 1))

  def aFactorialFunc(n : Int): Int={
    if(n==1) 1
    else n * aFactorialFunc(n-1)
  }
  println(aFactorialFunc(5))

  def myFibo(n: Int): Int = {
    if(n==0) 0
    else if(n<=2) 1
    else myFibo(n-1) + myFibo(n-2)
  }
  println(myFibo(2))

  def checkIfPrime(n: Int): Boolean={
    @tailrec
    def innerCheckIfPrime(i: Int): Boolean ={
      if(i<=1) true
      else n%i!=0 && innerCheckIfPrime(i-1)
    }
    innerCheckIfPrime(n/2)
  }
  println(checkIfPrime(49))

  def countNumberOfZerosInFactorial(n: Int): AnyVal = {
    var count2 = 0
    var count5 = 0
    @tailrec
    def findFact(n: Int, acc: Int): Unit ={
      var i = n
      if(n<=1) println(s"fact = "+ acc)
      else {
        while(i%5==0){
          //println("count5: "+i)
          count5+=1
          i = i/5
        }
        while(i%2==0){
          //println("count2: "+i)
          count2+=1
          i = i/2
        }
        findFact(n-1, n*acc)
      }
    }
    findFact(n,1)
    if(count2>=0 && count5 >=0) if(count2>=count5) count5 else count2
  }
  val findFact = 4
  println(s"Count of zeros in fact of $findFact= "+countNumberOfZerosInFactorial(findFact))
}
