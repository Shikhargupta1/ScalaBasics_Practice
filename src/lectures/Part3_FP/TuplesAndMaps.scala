package lectures.Part3_FP

object TuplesAndMaps extends App {

  val aTuple = (2, "Hello, Scala")
  println(aTuple)

  println(aTuple._2)
  val copiedTuple = aTuple.copy(_2 = "goodbye Java")
  println(copiedTuple)
  println(aTuple.swap)

  //Maps : keys -> values
  val aMap = Map[String,Int]()
  println(aMap)

  val phoneBook = Map(("John", 911), "Danny" -> 100).withDefaultValue(-1)
  // a -> b is sugar for (a,b)
  println(phoneBook)

  //map ops
  println(phoneBook.contains("John"))
  println(phoneBook("Mary"))

  //add a pairing
  val newPairing = "Mary" -> 789
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  // functionals on Map
  // map, filter, flatMap

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  //filterKeys
  println(phoneBook.view.filterKeys(x1 => x1.startsWith("J")).toMap)
  //mapValues
  println(phoneBook.view.mapValues("0121-" + _).toMap)

  //conversion to other collections
  println(newPhoneBook.toList)
  println(List(("Dan", 111)).toMap)

  val names = List("Shikhar","Ramesh","Vihaan","Gaurav","Raghu")
  println(names.groupBy(names => names.charAt(0)))

  val newPairing2: Map[String,Int] = newPhoneBook ++ Map("JOHN" -> 191)
  println(newPairing2)
  println(newPairing2.map(pair => pair._1.toLowerCase -> pair._2))



}
