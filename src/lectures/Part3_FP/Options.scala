package lectures.Part3_FP

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(1)
  val noOption: Option[Int] = None

  println(myFirstOption, noOption)

  //Unsafe API's
  def unSafeMethod(): String = null
  //val result = Some(unSafeMethod()) //or -> Some(null)  // WRONG, don't do this
  val result = Option(unSafeMethod()) // Some or None
  println(result)

  //Chained Methods
  def backupMethod: String = "A valid result"
  val chainedResult = Option(unSafeMethod()) orElse Option(backupMethod)

  //Design safe API's
  def betterUnsafeMethod = None
  def betterBackupMethod = Some("A valid result")

  val betterChainedMethod = betterUnsafeMethod orElse betterBackupMethod
  println(betterChainedMethod)

  //Functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get)    //Unsafe, do not use

  //map, flatMap, filter
  println(myFirstOption.map(_*2))
  println(myFirstOption.filter(_ % 2 == 0))
  println(myFirstOption.flatMap(x => Option(x*10)))

  // Exercises
  val config: Map[String, String] = Map(
    //fetched from elsewhere
    "host" -> "192.1681.1.1",
    "port" -> "80"
    )

  class Connection{
    def connect = "Connected" //connect to some server
  }

  object Connection{
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if(random.nextBoolean()) Some(new Connection)
      else None
  }

  //try to establish a connection, if so - print the connect method
  val host = config.get("host")
  val port = config.get("port")

  val testConnection = host.flatMap(h => port.flatMap(p => Connection.apply(h,p)))
  val connectionStatus = testConnection.map(c => c.connect)
  println(connectionStatus)
  connectionStatus.foreach(println)

  config.get("host").
    flatMap(h => config.get("port").
      flatMap(p => Connection(h,p)).
      map(c => c.connect)).foreach(println)

  val forConnectionStatus = for {
    h <- config.get("host")
    p <- config.get("port")
    c <- Connection(h,p)
  }yield c.connect

  forConnectionStatus.foreach(println)


}
