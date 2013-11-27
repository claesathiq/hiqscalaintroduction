package com.hiq.scala.introduction

/**
 * Currying and Partially Applied Functions
 */
object CurryingAndPartiallyApplied extends App {
  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p)

  val nums = List(1, 2, 3, 4, 5, 6, 7, 8)

  // Currying; turns a function of the form (A,B) => C into A => B => C, that is
  //   given a function of multiple arguments, it will produce a chain of functions
  //   that each take one argument and return a chain one shorter
  def modN(n: Int)(x: Int) = (x % n) == 0
  val mod2: (Int) => Boolean = modN(2)
  val mod3: (Int) => Boolean = modN(3)
  println(filter(nums, mod2))
  println(filter(nums, mod3))

  // Partially applying function; a function where some of its arguments have already been supplied
  def modP(n: Int, x: Int) = (x % n) == 0
  val modP2 = modP(2, _: Int)
  val modP3 = modP(3, _: Int)
  println(filter(nums, modP2))
  println(filter(nums, modP3))
}
