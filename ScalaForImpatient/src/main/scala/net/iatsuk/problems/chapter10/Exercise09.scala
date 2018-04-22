package net.iatsuk.problems.chapter10
package ex09

import java.io.{File, FileInputStream, InputStream, PrintWriter, BufferedInputStream => JavaBufferedInputStream}
import java.nio.file.Files

trait Logger {
  def log(msg: String)
}

trait EmptyLogger extends Logger {
  override def log(msg: String) {}
}

trait ConsoleLogger extends Logger {
  override def log(msg: String) {
    println(msg)
  }
}

trait BufferedInputStream extends InputStream with Logger {
  val buffer = new JavaBufferedInputStream(this)

  override def read(): Int = {
    val result = buffer.read()
    log("Read value: %d. Available: %d.".format(result, buffer.available()))
    result
  }
}

object Exercise09 extends App {
  val file = new File("ch10ex09.txt")
  val pw = new PrintWriter(file)
  pw.print("Hello World!")
  pw.close()

  val is = new FileInputStream(file) with BufferedInputStream with ConsoleLogger
  for (i <- 1 to 10) println(is.read().toChar)
  is.close()

  Files.deleteIfExists(file.toPath)
}
