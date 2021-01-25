package lectures.part2_OOps

import exercise.{Novel => Book, Writer}
import java.util.Date
import java.sql.{Date => sqlDate}
//import exercise._  --> imports everything from exercise

object PackagesAndImports extends App {
  val writer = new Writer("Daniel Bach","Starting a start-up",2050)
  sayHello
  println(pi)

  val newBook = new Book("XYZ",1000, writer.getFullName)

  val newDate = new Date
  val sqlDate = new sqlDate(2021,1,21) // OR  val sqlDate = new import java.sql.Date(2021,1,21)

  //default imports
  //java.lang - String, Object, Exception
  //scala - Int, Nothing, Function
  //scala.Predef - println, ???
}
