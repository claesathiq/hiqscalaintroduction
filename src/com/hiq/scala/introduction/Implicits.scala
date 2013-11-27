package com.hiq.scala.introduction

/**
 * Implicit parameters and implicit conversions and implicit classes
 */
object Implicits extends App {
  // Implicit parameter; Note the use of a rather unique type, to avoid accidental implicit matching
  class PreferredName(val name: String)
  implicit val preferredName = new PreferredName("Scala lovers")

  def greet(greeting: String)(implicit preferredName: PreferredName) {
    println(greeting + ", " + preferredName.name)
  }
  greet("Hello")(new PreferredName("HiQ"))
  greet("Hello")

  // Implicit conversion; Note that of course it makes little sense with an implicit conversion
  //   that causes loss of precision, like this one
  implicit def doubleToInt(x: Double) = x.toInt
  val i: Int = 3.5   // Would be illegal without the above implicit conversion
  println("i = " + i)

  // Implicit classes
  implicit class IntWithPretty(x: Int) {
    def pretty = println("Pretty " + x)
  }

  5 pretty
}
