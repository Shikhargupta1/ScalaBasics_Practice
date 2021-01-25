package lectures.Part3_FP

object MapFlatmapFilterFor extends App{

  val list1 = List(1,2,3,4)
  println(list1)
  println(list1.head)
  println(list1.tail)

  //map
  println(list1.map(x => x * 2))
  println(list1.map("Num: "+ _))

  //filter
  println(list1.filter(_%2 == 0))

  //flatmap
  val pairs = (x: Int) => List(x,x+1)
  println(list1.flatMap(pairs))

  //Combinations of lists
  val chars = List  ('a','b')
  val colors = List("Red","Blue","Green")

  val combinations = list1.flatMap( n => chars.map(c => ""+c+n))
  println(combinations)
  val moreCombos = list1.flatMap(n => chars.flatMap(c => colors.map(""+ n + c + "-" + _)))
  println(moreCombos)

  //Foreach
  list1.foreach(println)

  //for - comprehensions    --> this is exactly same as above moreCombos
  val forCombinations = for {
    n <- list1
    c <- chars
    col <- colors
  }yield ""+ n + c + "-" + col
  println(forCombinations)

  //forEach in for-comprehensions would look like
  for {
    n <- list1 if n%2==0
  }println(n)

  //syntax overload
  list1.map{ x =>
    x*2
  }



}
