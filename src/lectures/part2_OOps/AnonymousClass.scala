package lectures.part2_OOps

object AnonymousClass extends App {

  abstract class Animal{ // OR Trait Animal{} works fine for Anonymous class as well
    def eat: Unit
  }

  val anonAnimal = new Animal {
    def eat: Unit = println(this.getClass)
  }

  class Person(name: String) {
    def greet = println(s"User has joined $name community")
  }

  val changePerson = new Person("Java"){
     override def greet: Unit = println("User has exited this community \n"+this.getClass)
  }
  changePerson.greet
  anonAnimal.eat

}
