package net.iatsuk.problems.chapter09

object Exercise06 extends App {
  val s = "как эта, возможно с \" или \""
  "\".*\"".r.findAllIn(s).foreach(println)
}
