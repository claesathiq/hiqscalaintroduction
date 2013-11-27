package com.hiq.scala.introduction

/**
 * Closures
 */
object Closures extends App {
  val y = 2
  val v1 = (x: Int) => {
    println("Val is " + (x + y))
  }
  v1(3)

  // Note that Scala's Closures are not pure functional, they are dynamically bound
  // Therefor binding to a var can produce unexpected results
  var z = 2
  val v2 = (x: Int) => {
    println("Val is " + (x + z))
  }
  v2(3)
  z = 4
  v2(3)
}
