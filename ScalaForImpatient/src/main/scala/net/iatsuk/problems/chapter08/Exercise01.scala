package net.iatsuk.problems.chapter08
package ex1

class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double): Double = { super.deposit(amount); super.withdraw(1) }
  override def withdraw(amount: Double): Double = { super.withdraw(amount + 1) }
}

object Test extends App {
  val acc = new CheckingAccount(50)
  println(acc.deposit(1))
  println(acc.deposit(5))
  println(acc.withdraw(1))
}
