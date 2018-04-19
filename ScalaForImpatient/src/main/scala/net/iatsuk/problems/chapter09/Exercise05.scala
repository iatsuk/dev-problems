package net.iatsuk.problems.chapter09

import java.io.{File, PrintWriter}
import java.nio.file.Files

object Exercise05 extends App {
  val out = for (i <- 0 to 20) yield (math.pow(2, i), math.pow(2, -i))

  // out to console
  println("out:")
  out.foreach(tuple => println(tuple._1 + "\t" + tuple._2))

  // out to file
  val file = new File("ex05.txt")
  val pwOut = new PrintWriter(file)
  out.foreach(tuple => pwOut.println(tuple._1 + "\t" + tuple._2))
  pwOut.close()
  printf("saved to %s\n", file.getAbsolutePath)

  // clean up
  Files.deleteIfExists(file.toPath)
}
