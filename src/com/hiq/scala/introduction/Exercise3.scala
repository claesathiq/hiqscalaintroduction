package com.hiq.scala.introduction

/**
 * Exercise 3 - Return a list with all command line arguments in upper case
 */
object Exercise3 {
  def main(args: Array[String]) {
    val res = for (a <- args) yield a.toUpperCase
    println("Arguments: " + res.toString)
  }
}
