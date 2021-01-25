package ScalaTrainingTCS

object SetsAndMaps extends App {
  var jetSets = Set("Boeing", "Airbus")
  // Same as
  // jetSets : scala.collection.immutable.Set[String] = Set("Boeing", "Airbus")

  jetSets+="Lear"
  jetSets+="Boeing"

  println(jetSets.foreach(println))
  println(jetSets.contains("Cessna"))
  println(jetSets.contains("Boeing"))

  import scala.collection.mutable
  var movieSets = mutable.Set("Deadpool","Gone Girl")
  movieSets+="Avenger"
  println(movieSets)

  val hashSet = mutable.HashSet("Tomatoes","Chilies")
  println(hashSet+"Coriander")

  //************************************

  val numberMap = mutable.Map[Int,String]()
  numberMap+= (1 -> "One")
  numberMap+= (2 -> "Two")
  numberMap+= (3 -> "Three")

  println(numberMap)
  println(numberMap(1)+" "+numberMap(3))



}
