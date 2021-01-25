package lectures.part2_OOps

object Generics extends App {
  class MyList[+A]{
    def add[B >: A](n: B): MyList[B] = ???
  }

  class MyMap[key, value]{
  }

  val MapOfIntegers = new MyMap[Int,String]
  val listOfIntergers = new MyList[Int]
  val listOfStrings = new MyList[String]

  object MyList{
    def empty[A]: MyList[A] = new MyList[A]
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // VARIANCE Problem

  class Animal
  class Dog extends Animal
  class Cat extends Animal

  //1.  Yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? Hard Question  ==> We return a list of Animals

  //2. No = INVARIANCE
  class InvariantList[A]
  //val invariantListAnimal: InvariantList[Animal] = new InvariantList[Cat]     --> DOES NOT WORK
  val invariantListAnimal: InvariantList[Animal] = new InvariantList[Animal]


  //3. Hell, No! == Contravariant
  class Trainer[-A]
  val contravarientList: Trainer[Cat] = new Trainer[Animal]


  // Bounded Types
  class Cage[A <: Animal](animal: A)
  val cagedAnimal = new Cage(new Dog)

  //class Car
  //val newCage = new Cage(new Car)

}
