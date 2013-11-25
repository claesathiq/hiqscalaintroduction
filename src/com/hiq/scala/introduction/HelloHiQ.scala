package com.hiq.scala.introduction

/**
 * Companion objects
 * Often used for factory methods for class, fr instance to create case classes
 */
abstract class AbstractClass

class StringClass(s: String) extends AbstractClass {
  override def toString = "Hello " + s
}

class IntClass(i: Int) extends AbstractClass {
  override def toString = "Hello " + i
}
object AbstractClass {
  def apply(s: String) = {
    new StringClass(s)
  }
  def apply(i: Int) = {
    new IntClass(i)
  }
}

object Run {
  def main(args: Array[String]) {
    println(AbstractClass("HiQ"))
    println(AbstractClass(5))
  }
}
