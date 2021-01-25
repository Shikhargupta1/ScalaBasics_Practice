package lectures.part2_OOps

object Inheritance extends App {

  // single class inheritance
  sealed class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch


  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    //    override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)


  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other files
}


/*object InheritanceAndTraits extends App{

  sealed class Pets{
     def sound = println("Makes some sound")
    val creatureType = "Reptile"
  }

  class Dogs extends Pets{
    def barks = {
      sound
      println("Growls")
    }
  }

  val labra = new Dogs
  //labra.sound
  labra.barks

  class Person(name: String, age: Int){
    def this(name: String) = this(name,0)
  }
  class Adult(name: String, age: Int, idCard: Int) extends Person(name)

  class Cats(override val creatureType: String) extends Pets{
    //override val creatureType: String = "Mammal"
    override def sound: Unit = {
      super.sound
      println("Meow")
    }

    def eats(food: String) = println(s"This cat eats $food")
  }
  val cat = new Cats("Mammal")
  cat.sound
  println(cat.creatureType)


  val unknownAnimal: Pets = new Cats("Mammal")
  unknownAnimal.sound
  unknownAnimal.creatureType
}
*/