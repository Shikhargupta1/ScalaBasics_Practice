package lectures.part2_OOps

object MethodNotations extends App {

  class Person(val name:String, favMovie: String, val age: Int = 18){

    require(favMovie.length>0,"Invalid name")
    def likes(movie: String): Boolean = movie == favMovie
    def hangOutWith(person: Person): String = s"${this.name} likes to hangout with ${person.name}"
    def unary_! : String = s"$name, is not nice"
    def isAlive : Boolean = true
    def apply() : String = s"$name has called applied function"

    //Exercises
    def +(nickName: String) : Person = new Person(name+s" ($nickName)",favMovie)
    def unary_+ : Person = new Person(name,favMovie,age+1)
    def learns(skill: String) = s"$name learns $skill"
    def learnsScala = learns("Scala")
    def apply(n: Int) = s"$name watched $favMovie $n times"
  }

  val mary = new Person("Mary","Inception")

  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // Infix notation = operator notation

  //"operators" in Scala
  val tom = new Person("Tom","Fight club")
  println(mary hangOutWith tom)

  //ALl OPERATORS ARE METHODS.
  //Akka actors have ! ?
  println( 1 + 2 )
  println( 1.+(2)) // equivalent

  //prefix notation
  val x = -1
  val y = 1.unary_- // equivalent
  // Unary_prefix only works with + - ~ !

  println(mary.unary_!)
  println(!mary)

  //Postfix Notation
  println(mary isAlive)

  //apply()
  println(mary.apply())
  println(mary()) //  Equivalent

  //Exercises

  /*
    1.  Overload the + operator
        mary + "the rockstar" => new person "Mary (the rockstar)"
    2.  Add an age to the Person class
        Add a unary + operator => new person with the age + 1
        +mary => mary with the age incrementer
    3.  Add a "learns" method in the Person class => "Mary learns Scala"
        Add a learnsScala method, calls learns method with "Scala".
        Use it in postfix notation.
    4.  Overload the apply method
        mary.apply(2) => "Mary watched Inception 2 times"
   */

  println(mary + "The Nerd" name)
  println(+mary age)
  println(mary learnsScala)
  println(mary(4))


}
