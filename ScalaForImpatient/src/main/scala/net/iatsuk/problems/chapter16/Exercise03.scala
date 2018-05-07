package net.iatsuk.problems.chapter16

import scala.xml.Text

object Exercise03 extends App {
  val match1: String = <li>Fred</li> match { case <li>{Text(t)}</li> => t }
  val match2: String = <li>{"Fred"}</li> match { case <li>{Text(t)}</li> => t; case _ => "none" }

  println(match1)
  println(match2)
}
