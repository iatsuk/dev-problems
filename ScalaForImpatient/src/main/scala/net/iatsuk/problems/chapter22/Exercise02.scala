package net.iatsuk.problems.chapter22

import scala.util.continuations.{reset, shift}

object Exercise02 extends App {
  var cont: (String => String) = null
  var filename = "myfile.txt"
  var contents = ""

  reset {
    while (contents == "") {
      try {
        contents = scala.io.Source.fromFile(filename, "UTF-8").mkString
      } catch { case _ => }
      filename = shift { k: (String => String) => cont = k; "shift" }
    }
    "end"
  }

  if (contents == "") cont(scala.io.StdIn.readLine("Try another filename: "))
  println(contents)
}
