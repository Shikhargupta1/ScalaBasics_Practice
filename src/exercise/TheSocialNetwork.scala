package exercise

import java.nio.channels.NetworkChannel

object theSocialNetwork extends App {

  def add(network: Map[String,Set[String]], person: String): Map[String,Set[String]] =
    network + (person -> Set())

  def addFriend(network: Map[String,Set[String]], a: String, b: String): Map[String,Set[String]] =
    network + (a -> (network(a) + b)) + (b -> (network(b) + a))


  def unfriend(network: Map[String,Set[String]], a: String, b: String): Map[String,Set[String]] ={
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
    //network + (a -> friendsA.filter(x => x!=b)) + (b -> friendsB.filter(x => x!=a))
  }

  def remove(network: Map[String,Set[String]], person: String): Map[String,Set[String]] = {
    def removeAux(friends: Set[String], networkAccum: Map[String,Set[String]]): Map[String,Set[String]]={
      if (friends.isEmpty) networkAccum
      else removeAux(friends.tail, unfriend(networkAccum, person, friends.head))
    }
    val unFriended = removeAux(network(person), network)
    unFriended - person
  }

  def nFriends(network: Map[String,Set[String]], a: String): Int = {
    if(!network.contains(a)) -1
    else network(a).size
  }

  def numberOfMutualFriends(network: Map[String,Set[String]], a: String, b: String): Int = {
    if(!network.contains(a) || !network.contains(b)) return -1
    else {
      val friendA = network(a)
      val friendB = network(b)
      friendA.intersect(friendB).size
    }
  }

  def mostFriends(network: Map[String,Set[String]]): String = {
    /*def auxFriends(networkAcc: Map[String,Set[String]], a: String): String ={
      if(networkAcc.isEmpty) a
      else if(network(a).size < networkAcc.head._2.size)
        auxFriends(networkAcc.tail, networkAcc.head._1)
      else auxFriends(networkAcc.tail, a)
    }
    auxFriends(network, network.head._1)*/

    network.maxBy(pair => pair._2.size)._1
  }

  def lonelyPeople(network: Map[String,Set[String]]): Map[String,Set[String]] = {
    network.filter(pair => pair._2.isEmpty)
  }

  def socialConnection(network: Map[String,Set[String]], a: String, b: String): Boolean ={
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean ={
      if(discoveredPeople.isEmpty) false
      else{
        val person = discoveredPeople.head
        if(person == target) true
        else if(consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a)+a)
  }

  val emptyNetwork: Map[String,Set[String]] = Map()
  /*val theNetwork = add(add(emptyNetwork,"Bob"), "Mary")
  println(theNetwork)

  addFriend(theNetwork,"Bob","Mary")
  println(addFriend(theNetwork,"Bob","Mary"))
  println(unfriend(addFriend(theNetwork,"Bob","Mary"), "Bob", "Mary"))
  println(remove(addFriend(theNetwork,"Bob","Mary"), "Bob"))
  /*val theNetwork = Map(("John" -> Set("Mary","Jane","Harry")), "Mary" -> Set("Oliver", "John", "Hermione"))
  theNetwork.add(theNetwork, "Ron")*/*/

  val newNetwork = add(add(add(emptyNetwork,"Bob"), "Mary"), "Jim")
  println(newNetwork)
  println(addFriend(addFriend(newNetwork,"Bob","Mary"), "Bob", "Jim"))

  println(nFriends(addFriend(addFriend(newNetwork,"Bob","Mary"), "Bob", "Jim"), "Mary"))
  println(numberOfMutualFriends(addFriend(addFriend(newNetwork,"Bob","Mary"), "Mary", "Jim"), "Jim" , "Mary"))
  println(mostFriends(addFriend(addFriend(newNetwork,"Bob","Mary"), "Bob", "Jim")))
  println(lonelyPeople(addFriend(newNetwork,"Bob","Mary")).keySet)
  println(socialConnection(newNetwork, "Jim", "Mary"))

}
