package ScalaTrainingTCS

import java.util.Scanner

object Looping {
  def main(args: Array[String]): Unit = {
    /*var i = 0
    while(i>=args.length-1){
      println(args(0))
      i+=1
    } */

    /*for(i <- 1 to 6) if (i%2 == 0){
      println(i)
    }
    println("***********************")

    for(i <- 1 to 10 if(i%2==0)){
      println(i)
    }

    for(i <- 1 to 6){
      if (i%2 == 0)
      println(i)
    }*/

    val a1 = for(i <- 1 to 100 if(i%2==0)) yield(i)
    println(a1)

    val a2 = for(i <- 1 to 100) yield{if(i%2==0) i}
    println(a2)




  }


}
