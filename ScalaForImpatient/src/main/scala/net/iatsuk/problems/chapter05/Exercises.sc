import scala.beans.BeanProperty

// 1
class Counter {
  private var value = 0
  def increment() { if (value < Int.MaxValue) value += 1 }
  def current = value
}

// 2
class BankAccount {
  private var _balance = 0
  def balance = _balance
  def deposit(amount: Int) { _balance += amount }
  def withdraw(amount: Int) { _balance -= amount }
}

// 3
class Time(val hours: Byte, val minutes: Byte) {
  def before(other: Time): Boolean = hours <= other.hours && minutes < other.minutes
}

// 4
class newTime(val hours: Byte, val minutes: Byte) {
  private val fromMidnight = hours * 60 + minutes
  def before(other: newTime): Boolean = fromMidnight < other.fromMidnight
}

// 5
class Student {
  @BeanProperty var name = ""
  @BeanProperty var id = 0
}
val student = new Student
student.setId(5)

// 6
class Person(var age: Int) {
  if (age < 0) age = 0
}

// 7
class newPerson(name: String) {
  val firstName = name.split(' ')(0)
  val lastName = name.split(' ')(1)
}

// 8
class Car(val origin: String, val model: String, val year: Short, var registration: String) {
  def this(origin: String, model: String) { this(origin, model, -1, "") }
  def this(origin: String, model: String, year: Short) { this(origin, model, year, "") }
  def this(origin: String, model: String, registration: String) { this(origin, model, -1, registration) }
}

// 10
class Employee(val name: String = "John Q. Public", var salary: Double = 0.0) {}
