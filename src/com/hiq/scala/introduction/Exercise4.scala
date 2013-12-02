package com.hiq.scala.introduction

/**
 * Exercise 4 - Sum up all command line arguments
 */
object Exercise4 {
  def main(args: Array[String]) {
    try {
      val elems = args map Integer.parseInt
      println("The sum of all arguments is: " + elems.foldRight(0) (_ + _))
    } catch {
      case e: NumberFormatException =>
        println("Usage: scala com.hiq.scala.introduction.Exercise4 <n1> <n2> ... ")
    }
  }
}
