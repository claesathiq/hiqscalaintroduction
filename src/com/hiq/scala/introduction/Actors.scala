package com.hiq.scala.introduction

import akka.actor.{ActorSystem, Actor, Props}

/**
 * Actors
 */
object Actors extends App {
  class HelloWorld extends Actor {

    override def preStart(): Unit = {
      val greeter = context.actorOf(Props[Greeter], "greeter")
      greeter ! Greeter.Greet
    }

    def receive = {
      case Greeter.Done ⇒ context.stop(self)
    }
  }

  object Greeter {
    case object Greet
    case object Done
  }

  class Greeter extends Actor {
    def receive = {
      case Greeter.Greet ⇒
        println("Hello World!")
        sender ! Greeter.Done
    }
  }

  val system = ActorSystem("actors")
  system.actorOf(Props[HelloWorld], "helloworld")
}
