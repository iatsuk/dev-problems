package net.iatsuk.problems.chapter22

import scala.util.continuations._

object Exercise01 extends App {
  var cont: (Unit => Unit) = null
  var filename = "myfile.txt"
  var contents = ""

  reset {
    while (contents == "") {
      try {
        contents = scala.io.Source.fromFile(filename, "UTF-8").mkString
      } catch { case _ => }
      shift { k: (Unit => Unit) =>
        cont = k
      }
    }
  }

  if (contents == "") {
    filename = scala.io.StdIn.readLine("Try another filename: ")
    cont()
  }
  println(contents)
}
