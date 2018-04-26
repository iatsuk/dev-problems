package net.iatsuk.problems.chapter13

object Exercise10 extends App {
  val str = "qwertyuiasdfghejzxcvbnmdfghjqwer"
  val frequencies = str.par.aggregate(Map[Char, Int]())(
    (map, ch) => map + (ch -> (map.getOrElse(ch, 0) + 1)),
    (u, v) => (u.keySet ++ v.keySet).map { k => (k, u.getOrElse(k, 0) + v.getOrElse(k, 0)) }.toMap)
  println(frequencies)
}
