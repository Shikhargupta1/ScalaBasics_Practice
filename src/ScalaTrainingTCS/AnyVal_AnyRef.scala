package ScalaTrainingTCS

object AnyVal_AnyRef extends App {

  class ABC(val a: Int) extends AnyRef
  class XYX(val a: Int) extends AnyVal

  val ref1_ABC = new ABC(1)
  val ref2_ABC = new ABC(1)

  val ref1_XYZ = new XYX(1)
  val ref2_XYZ = new XYX(1)

  println(ref1_ABC == ref2_ABC)
  println(ref1_XYZ == ref2_XYZ)

  //println(ref1_ABC eq ref1_XYZ)
  //println(ref1_XYZ eq ref2_XYZ)

}
