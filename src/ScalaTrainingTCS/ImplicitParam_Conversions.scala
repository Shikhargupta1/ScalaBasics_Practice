package ScalaTrainingTCS

object ImplicitParam_Conversions extends App {

  implicit val pi = 3.14

  def areaOfCircle(r: Int)(implicit val_of_pi: Double) =
    val_of_pi * r * r

  println(areaOfCircle(1))

  case class CoOrdinates(x:Int,y:Int){
    def +(that: CoOrdinates): CoOrdinates = CoOrdinates(this.x+that.x, this.y+that.y)
  }

  implicit def stringToCoOrdinates(s: String)={
    val split_vals = s.split(",")
    if(split_vals.length > 1)
      CoOrdinates(Integer.parseInt(split_vals(0)),Integer.parseInt(split_vals(1)))
    else CoOrdinates(0,0)
  }

  val nextCoOrdinate = CoOrdinates(55,2) + "2,2"
  println(nextCoOrdinate)
//  println(s"${nextCoOrdinate.x}, ${nextCoOrdinate.y}")
}
