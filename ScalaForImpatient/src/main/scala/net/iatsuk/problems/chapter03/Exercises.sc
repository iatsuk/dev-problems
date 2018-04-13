import java.awt.datatransfer._

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

// 1
val n = 5
val a1 = new Array[Int](n)
for (i <- 0 until n) a1(i) = i
a1

for (i <- 0 until n) yield i

// 2
val a2 = Array(1, 2, 3, 4, 5)
for (i <- 1 until (a2.length, 2)) {
  val first = a2(i - 1)
  a2(i - 1) = a2(i)
  a2(i) = first
}
a2

// 3
val a3 = Array(1, 2, 3, 4, 5)
for (i <- a3.indices) yield {
  if (i % 2 == 0) {
    if (i + 1 >= a3.length) a3(i) else a3(i + 1)
  } else a3(i - 1)
}

// 4
val a4 = Array(1, 2, 0, 3, -7, -6, 5, 0)
val partitions = a4.partition(_ > 0)
partitions._1 ++ partitions._2

// 5
val a5 = Array(3.14, 2.71, -1.0)
a5.sum / a5.length

// 6
val a6 = Array(4, 3, 1, 2, 7, 8, 5)
a6.sortWith(_ > _)
a6.reverse

val b6 = ArrayBuffer(4, 3, 1, 2, 7, 8, 5)
b6.sortWith(_ > _)
b6.reverse

// 7
val a7 = Array(1, 1, 2, 3, 3, 3, 5)
a7.distinct

// 8
val a8 = ArrayBuffer(1, 2, 0, 3, -7, -6, 5, 0)
val indexes = for (i <- a8.indices if a8(i) < 0) yield i
for (i <- indexes.reverse.dropRight(1)) a8.remove(i)
a8

// 9
java.util.TimeZone.getAvailableIDs.
  filter(_.startsWith("America")).
  map(_.drop(8)).
  sortWith(_ < _)

// 10
val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
val natives: mutable.Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)