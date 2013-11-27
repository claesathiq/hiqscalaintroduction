package com.hiq.scala.introduction

/**
 * Default parameter values
 * Named parameters
 */
object ScalaParams extends App {

  class MyMap[K,V](initCapacity: Int = 16, loadFact: Float = 0.75f) {
    override def toString: String = {
      "Capacity [" + initCapacity + "], load factor [" + loadFact + "]"
    }
  }

  // Default parameter values
  val m1 = new MyMap[String,Int]()
  println(m1)

  val m2 = new MyMap[String,Int](12)
  println(m2)

  val m3 = new MyMap[String,Int](8, 0.5f)
  println(m3)

  // Names parameters
  // When using named parameters, the parameter order does not matter
  val m4 = new MyMap[String,Int](loadFact = 0.8f, initCapacity = 24)
  println(m4)

  // Named parameters go particularly well with default parameter values
  val m5 = new MyMap[String,Int](loadFact = 0.6f)
  println(m5)
}
