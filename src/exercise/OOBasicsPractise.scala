package exercise

import exercise.Novel.novels
import exercise.Writer.writers

object OOBasicsPractise extends App {
  val w1 = new Writer("John","Mackenzie",1954)
  val w2 = new Writer("Paulo", "Coelho", 1947 )

  val n1 = new Novel("Sign of the times", 1982, "John Mackenzie")
  val n2 = new Novel("The Alchemist", 1988, "Paulo Coelho")
  val n3 = new Novel("Eleven Minutes", 2003, "NA")

  n1.authorAge()
  n2.authorAge()
  n3.isWrittenBy("Paulo Coelho")
  n2.copy(2000)

}

object Writer {
  var writers = scala.collection.mutable.Map[String,Int]()
}

object Novel {
  var novels = scala.collection.mutable.Map[String,(Int,String)]()
}

class Writer(firstName: String, lastName: String, year: Int){
  writers = writers + (getFullName.toUpperCase -> (year))
  def getFullName: String = return (firstName+" "+lastName)
  //println(writers)
}

class Novel(name: String, yearOfRelease: Int, author: String){

  novels = novels + (name.toUpperCase -> (yearOfRelease,author.toUpperCase))
  def authorAge(): Unit = {
    if(Writer.writers.contains(author.toUpperCase)){
      val yearOfBirth = Writer.writers(author.toUpperCase)
      println(s"Age of $author at time of releasing $name was "+{yearOfRelease - yearOfBirth})
      return yearOfRelease - yearOfBirth
    }
    else return ()
  }

  def isWrittenBy(auth: String): Unit ={
    if(Writer.writers.contains(auth.toUpperCase)){
      novels(name.toUpperCase()) = (yearOfRelease,auth.toUpperCase)
    }
    else{
      Writer.writers + (auth.toUpperCase -> 0)
      novels(name) = (yearOfRelease,auth.toUpperCase)
    }
    println("Updated Novels and Authors\n"+writers +"\n"+novels +"\n")
  }

  def copy(newYearOfRelease: Int): Unit ={
    new Novel(name,newYearOfRelease,author)
    println(s"Year of release updated for $name", novels)
  }
  //println(novels)
}
