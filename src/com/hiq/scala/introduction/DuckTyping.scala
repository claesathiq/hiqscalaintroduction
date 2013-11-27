package com.hiq.scala.introduction

import com.hiq.scala.introduction.DuckTypes._

/**
 * Duck Typing, or structural typing
 */
object DuckTyping extends App {
  class Duck {
    def quack = println("Quaaaaaack!")
    def feathers = println("The duck has white feathers")
  }
  class Person {
    def quack = println("The person imitates a duck")
    def feathers = println("The person is a featherless type of duck")
  }
  def inTheForest(duck: { def quack; def feathers }) = { duck.quack; duck.feathers }
  inTheForest(new Duck())
  inTheForest(new Person())

  // Better is to define a Type, see DuckTypes.scala:
  //     object DuckTypes { type Quacker = {def quack; def feathers} }
  // then import where needed
  // import DuckTypes._
  def inTheDuckTypeForest(duck: Quacker) { duck.quack; duck.feathers }
  inTheForest(new Duck())
  inTheForest(new Person())
}
