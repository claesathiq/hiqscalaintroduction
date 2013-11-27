package com.hiq.scala.introduction

/**
 * Scala's lexical parser is greedy
 */
object Main {

  def main(args: Array[String]) {

    // Will parse greedily, thus consuming "." together with "1", yielding "1.", which is interpreted as a Double
    println( 1.+(2) )
    // The below line makes it cleared what the parser does
    println( 1. + 2 )

    // To avoid the above greediness we need to demarcate the "1" explicitly with parenthesis
    println( (1).+(2) )
  }

}
