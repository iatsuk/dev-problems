package net.iatsuk.problems.chapter09

import java.io._
import java.nio.file.Files

import scala.collection.mutable.ArrayBuffer

@SerialVersionUID(42L) class Person(val name: String) extends Serializable {
  val friends = new ArrayBuffer[Person]()
  override def toString = s"Person(name=$name, friends=$friends)"
}

object Exercise10 extends App {
  val fred = new Person("Fred")
  val george = new Person("George")
  val marry = new Person("Marry")
  val sam = new Person("Sam")

  fred.friends += george += marry += sam
  george.friends += marry += sam
  marry.friends += sam

  val persons = ArrayBuffer(fred, george, marry, sam)

  println("Before Serialization:")
  persons.foreach(println)

  // serialize
  val file = new File("friends.ser")
  val out = new ObjectOutputStream(new FileOutputStream(file))
  out.writeObject(persons)
  out.close()

  // deserialize
  val in = new ObjectInputStream(new FileInputStream(file))
  val ser = in.readObject().asInstanceOf[ArrayBuffer[Person]]
  in.close()

  // assert
  println("\nAfter deserialization:")
  ser.foreach(println)

  // clean up
  Files.deleteIfExists(file.toPath)
}
