package lectures.part1Basics

object DefaultArgs extends App{

  def trFact(n: Int, accum: Int = 1 ): Int ={   //  providing default value of accumulator so that user does not have to worry.
    if(n<=1) accum
    else trFact(n-1,n*accum)
  }

  println(trFact(5))

  // But problems with default values
  def savePics(format: String="JPG", len: Int, wid: Int): Unit = println("Pic Saved")

  //savePics(800,1000) Compiler is confused weather the first arg is format or len

  //Solution : Use name of arg while passing

  savePics(len = 800, wid = 1000)
  //Also below is valid i.e. arg order can be changed
  savePics(wid = 1000, len = 800)

}
