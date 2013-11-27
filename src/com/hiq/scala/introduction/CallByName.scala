package com.hiq.scala.introduction

/**
 * Automatic Type-Dependent Closure Construction
 * aka: Call By Name
 */
object CallByName extends App {
  def visibleOps(r: Int) = {
    println("Running visible Ops")
    r // return value
  }

  def callByValue(x: Int) = {
    println("x1=" + x)
    println("x2=" + x)
  }

  def callByName(x: => Int) = {
    println("x1=" + x)
    println("x2=" + x)
  }

  callByValue(visibleOps(2))
  println("------------------")
  callByName(visibleOps(2))
}
