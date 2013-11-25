package com.hiq.scala.introduction

/**
 * The magic apply an d unapply functions
 * Also Option: Some and None
 * Also typed variable and implicitly typed variable
 * Also extending App instead of defining main
 */
object Applying extends App {

  object Twice {
    def apply(x: Int): Int = x * 2
    def unapply(z: Int): Option[Int] = if (z%2 == 0) Some(z/2) else None
  }

  val x: Int = Twice(21)
  x match { case Twice(n) => println(n) }

  val y = 22
  y match { case Twice(n) => println(n) }

  val z = 21
  z match {
    case Twice(n) => println(n)
    case _ =>
  }
}
