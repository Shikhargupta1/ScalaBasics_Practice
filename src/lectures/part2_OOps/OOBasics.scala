package lectures.part2_OOps

object OOBasics extends App {
  val p1 = new Person("Lupin", Int.MaxValue)
  println(p1)
  //println(p1.name) --> Not accessible as Class param are not Fields.
  // To convert param's to field, use val or var - Ex. age below

  println(p1.age)
  println(p1.x)
  p1.greet("Daniel")
  p1.greet()

 }

// Constructor
class Person(name: String, val age: Int){
  //Class param are not Fields.

  val x = 2
  println(1+3)

  def greet(name: String):Unit = println(s"$name says: Hi ${this.name}")
  def greet() = println(s"Hi $name")

  def this(name: String) = this(name,0)   //  Auxiliary Constructors --> Not very useful in Scala
  def this() = this("John", 22)

}


