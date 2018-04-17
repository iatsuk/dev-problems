package net.iatsuk.problems.chapter07

import java.lang.System._

object Exercise09 extends App {
  val user = getProperty("user.name")
  val pass = Console.readLine()
  if (pass.length < 8) {
    err.println("Password is weak")
  } else {
    out.println(s"Hello $user!")
  }
}
