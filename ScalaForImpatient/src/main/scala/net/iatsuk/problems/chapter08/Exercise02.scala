package net.iatsuk.problems.chapter08
package ex2

class BankAccount(initialBalance: Double) {
  private var balance = initialBalance

  def deposit(amount: Double) = {
    balance += amount; balance
  }

  def withdraw(amount: Double) = {
    balance -= amount; balance
  }
}

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private var freeOperations = 3

  def earnMonthlyInterest() = {
    val percentages = super.deposit(0) * 0.1
    super.deposit(percentages)
    freeOperations = 3
  }

  override def deposit(amount: Double): Double = {
    val deposit = super.deposit(amount)
    if (freeOperations > 0) { freeOperations -= 1; deposit } else { super.withdraw(1) }
  }

  override def withdraw(amount: Double): Double = {
    if (freeOperations > 0) { freeOperations -= 1; super.withdraw(amount) } else { super.withdraw(amount + 1) }
  }
}
