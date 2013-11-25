package com.hiq.scala.introduction

/**
 * Sequence comprehensions
 * Also note that println is an alias for Console.println
 */
object Comprehension extends App {

  def even(from: Int, to: Int): List[Int] =
    for (i <- List.range(from, to) if i % 2 == 0) yield i

  Console.println(even(0, 20))

}
