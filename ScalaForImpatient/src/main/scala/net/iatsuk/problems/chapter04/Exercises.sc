import java.io.{File, FileWriter}
import java.nio.file.Files
import java.util.{Calendar, Scanner}

import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.immutable.TreeMap
import scala.collection.mutable

// prepare
val writer = new FileWriter("words.txt")
writer.write("Hello Dolly Hello\nLorem Impsum dolor amet")
writer.close()

// 1
val prices = Map("Book" -> 50, "Notebook" -> 2000)
for ((k, v) <- prices) yield (k, v * 0.9)

// 2
val words2 = new mutable.HashMap[String, Int]()
val in2 = new Scanner(new File("words.txt"))
while (in2.hasNext()) {
  val word = in2.next()
  words2(word) = words2.getOrElse(word, 0) + 1
}
for ((word, acc) <- words2) printf("%s: %d\n", word, acc)

// 3
var words3 = Map[String, Int]()
val in3 = new Scanner(new File("words.txt"))
while (in3.hasNext()) {
  val word = in3.next()
  val acc = words3.getOrElse(word, 0) + 1
  words3 = words3 + (word -> acc)
}
for ((word, acc) <- words3) printf("%s: %d\n", word, acc)

// 4
var words4 = TreeMap[String, Int]()
val in4 = new Scanner(new File("words.txt"))
while (in4.hasNext()) {
  val word = in4.next()
  val acc = words4.getOrElse(word, 0) + 1
  words4 = words4 + (word -> acc)
}
for ((word, acc) <- words4) printf("%s: %d\n", word, acc)

// 5
val words5 = new java.util.TreeMap[String, Int]()
val in5 = new Scanner(new File("words.txt"))
while (in5.hasNext()) {
  val word = in5.next()
  val acc = words5.getOrDefault(word, 0) + 1
  words5.put(word, acc)
}
for ((word, acc) <- words5) printf("%s: %d\n", word, acc)

// 6
val map6 = mutable.LinkedHashMap(
  "Monday" -> java.util.Calendar.MONDAY,
  "Tuesday" -> java.util.Calendar.TUESDAY,
  "Wednesday" -> java.util.Calendar.WEDNESDAY,
  "Thurstday" -> java.util.Calendar.THURSDAY,
  "Friday" -> java.util.Calendar.FRIDAY,
  "Saturday" -> Calendar.SATURDAY,
  "Sunday" -> Calendar.SUNDAY
)
for ((k, v) <- map6) printf("%s: %d\n", k, v)

// 7
val props: collection.Map[String, String] = System.getProperties
val maxKeyLength = props.keys.maxBy(_.length).length
val maxValueLength = props.values.maxBy(_.length).length
println("-" * (maxKeyLength + maxValueLength + 3))
for ((k, v) <- props) printf("%-" + maxKeyLength + "s | %s\n", k, v)
println("-" * (maxKeyLength + maxValueLength + 3))

// 8
def minmax(values: Array[Int]) = {
  (values.min, values.max)
}
minmax(Array(1, 3, 5, 8, 2, 4, -5))

// 9
def lteqgt(values: Array[Int], v: Int) = {
  val more = values.partition(_ > v)
  val oth = more._2.partition(_ == v)
  (more._1.length, oth._1.length, oth._2.length)
}
lteqgt(Array(1, 3, 5, 4, 8, 2, 4, -5), 4)

// 10
"Hello".zip("World")

// clean up
Files.deleteIfExists(new File("words.txt").toPath)