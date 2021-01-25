package lectures.part1Basics

object Expressions extends App {
  val x = 1 + 2  // Expression
  println(x)

  println(2+3*4)  //BODMAS applies

  // Other operators : + - * /
  // & | ^ << >>
  // >>> right shift with zero extension

  println( 1 == x)
  // == != > < >= <=

  //also
  println(!(1==x))

  var aVariable = 2
  aVariable+=3  // -= *= /=
  println(aVariable)

  //****************
  //Instruction (DO) vs Expression (value)

  // IF expression
  val aCondition = true
  val aConditionValue = if(aCondition) 1 else 0
  println(aConditionValue)

  println(if(aCondition) 1 else 0)

  // Loop

  var i = 0
  while (i<10){
    print(i + " ")
    i+=1
  }
  println()
  // Never write this again
  // Loops in general is considered imperative programming, not appreciated in Scala

  //**************
  //Everything in Scala is an Expressions i.e. returns some value

  val aWeirdVariable = (aVariable = 3)  // returns Unit i.e. === void
  println(aWeirdVariable)

  //side effects : println(), whiles, reassigning  // Side effects return UNIT

  //Code Blocks

  val aCodeBlock = {
    val y = 2       // Local value
    val z = y+1     // i.e can only be accessed inside this code block

    if(z<2) "hello" else "bye"  // or // if(z<2) "hello" else 0
  }
  println(aCodeBlock)

  //*******************************
  // Some questions:

  //1.  Diff btw "Hello World" and println("Hello World")
  //
  //"Hello World" is a string literal while println("Hello World") is an expression and it is a side effect.

  //2.
  val someValue = {
    2<3
  }
  //  println(someValue) = true

  val someOtherValue = {
    if (someValue) 10 else 100
    50
  }
  // println(someOtherValue) = 50     ie  the last expression in the code block
}
