package com.hiq.scala.introduction

/**
 * XML processing in Scala
 */
object ScalaXml extends App {
  val page =
<html>
  <head>
    <title>Hello XHTML world</title>
  </head>
  <body>
    <h1>Hello world</h1>
    <p><a href="scala-lang.org">Scala</a> talks XHTML</p>
  </body>
</html>
  println(page.toString())
  println()

  import java.text.DateFormat._
  val df = getDateInstance
  val dateString = df.format(new java.util.Date())
  def theDate(name: String) =
<dateMsg addressedTo={ name }>
  Hello, { name }! Today is { dateString }
</dateMsg>
  println(theDate("Scala lovers").toString())
}
