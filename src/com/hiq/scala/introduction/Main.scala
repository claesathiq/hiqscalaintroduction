package com.hiq.scala.introduction

/**
 * Everything is an object
 */
object Main {
  def main(args: Array[String]) {
    val x = 2
    println(1 + 2 + 3 + x)

    val y = 1.+(2)
    println(y.+(3.+(x)))

    // The above also means that +,* etc are valid identifiers in Scala

    class Oper(val v: Int) {
      def * = v + v;
    }

    val o = new Oper(5)
    println(o *)
  }
}
