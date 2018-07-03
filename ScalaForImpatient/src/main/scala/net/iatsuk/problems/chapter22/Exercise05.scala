package net.iatsuk.problems.chapter22

import scala.util.continuations._

object Exercise05 extends App {
  var cont: Unit => String = null
  val a = "Marry was a little lamb".split(" ")
  reset {
    var i = 0
    while (i < a.length) {
      shift {
        k: (Unit => String) => {
          cont = k
          a(i)
        }
      }
      i += 1
    }
    ""
  }
  println(cont())
  println(cont())
}
