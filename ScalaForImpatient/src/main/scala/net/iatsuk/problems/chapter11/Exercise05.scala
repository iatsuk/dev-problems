package net.iatsuk.problems.chapter11

class Table() {
  val sb = new StringBuilder("<table><tr>")
  def |(s: String): Table = { sb.append(s"<td>$s</td>"); this }
  def ||(s: String): Table = { sb.append(s"</tr><td>$s</td>"); this }
  def mkString: String = sb.mkString + "</tr></table>"
  override def toString: String = mkString
}

object Exercise05 extends App {
  val table = new Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET"
  println(table)
}
