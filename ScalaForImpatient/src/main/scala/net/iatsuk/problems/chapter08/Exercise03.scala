package net.iatsuk.problems.chapter08
package ex3

abstract class Animal {
  def voice()
}

class Cat extends Animal {
  override def voice(): Unit = println("Meow")
}

class Dog extends Animal {
  override def voice(): Unit = println("Woof")
}
