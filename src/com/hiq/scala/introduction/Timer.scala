package com.hiq.scala.introduction

object Timer {

  def oncePerSecond(callback: () => Unit) {
    while (true) {
      callback();
      Thread sleep 1000
    }
  }

  def main(args: Array[String]) {
    oncePerSecond(() =>
      println("Time flies when you're having fun")
    )
 }

}
