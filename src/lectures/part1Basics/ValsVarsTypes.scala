package lectures.part1Basics

import com.sun.org.apache.xpath.internal.operations.Bool

import java.util.concurrent.Delayed

object ValsVarsTypes extends App {

  val x: Int = 50
  //println(x)

  //VALS are IMMUTABLE --> x = 51 : not allowed

  val y = 10 // Compiler can infer types

  val aString : String= "Hello" //; val anotherString = "Bye"

  val abool : Boolean = true
  val aChar : Char = 'a'
  val assignInt : Int = x
  val aShort : Short = -32768 // -2^15 to 2^15
  val aLong : Long = 1123456789234512342L
  val aFloat : Float = 0.21f
  val aDouble : Double = 0.21121212345678932456781234567934

  // VARS are MUTABLE

  var x1 = 10
  x1 = 11 // side effects


}
