package net.iatsuk.problems.chapter08
package ex5

class Point(val x: Double, val y: Double) {

}

class LabeledPoint(val label: String, override val x: Double, override val y: Double) extends Point(x, y) {

}
