package com.hiq.scala.introduction

/**
 * Exercise 1 - command line parser
 */
object Exercise1 {
  var verbose = false

  def main(args: Array[String]) {
    for (a <- args) a match {
      case "-h" | "-help"    =>
        println("Usage: scala com.hiq.scala.introduction.Exercise1 [-help|-verbose]")
      case "-v" | "-verbose" =>
        verbose = true
      case x =>
        println("Unknown option: '" + x + "'")
    }
    if (verbose)
      println("Running in verbose mode")
  }
}
