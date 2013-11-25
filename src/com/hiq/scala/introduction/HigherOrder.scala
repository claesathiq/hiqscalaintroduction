package com.hiq.scala.introduction

/**
 * Higher order functions
 */
object HigherOrder extends App {

  class Decorator(left: String, right: String) {
    def layout[A](x: A) = left + x.toString() + right
  }

  def applyFunc(f: Int => String, v: Int) = f(v)

  val decorator = new Decorator("[", "]")
  println(applyFunc(decorator.layout, 7))
}
