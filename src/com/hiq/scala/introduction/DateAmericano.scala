package com.hiq.scala.introduction

import java.util.{Date, Locale}
import java.text.DateFormat._

object DateAmericano {
  def main(args: Array[String]) {
    val now = new Date
    val df = getDateInstance(LONG, Locale.US)
    println(df format now)
  }
}
