package com.hiq.scala.introduction

import scala.annotation.tailrec

/**
 * Exercise 2 - add "!" to compute factorial, to the class Int
 * NOTE: This solution is not tail recursive
 */
object Exercise2 extends App {
  def fact(n: Int): BigInt =
    if (n == 0) 1 else n * fact(n-1)

  implicit class IntWithFact(n: Int) {
    def ! = fact(n)
  }

  println("10! = " + (10!))
}
