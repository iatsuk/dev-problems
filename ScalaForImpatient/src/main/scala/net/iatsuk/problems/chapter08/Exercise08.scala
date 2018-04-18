package net.iatsuk.problems.chapter08
package ex8

class Person(val name: String) {
  override def toString: String = getClass.getName + "[name=" + name + "]"
}

class SecretAgent(codename: String) extends Person(codename) {
  override val name: String = "secret"
  override def toString: String = "secret"
}