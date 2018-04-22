package net.iatsuk.problems.chapter10

import java.io.{File, FileInputStream, InputStream, PrintWriter, BufferedInputStream => JavaBufferedInputStream}
import java.nio.file.Files

trait BufferedInputStream {
  this: InputStream => {
    val buffer = new JavaBufferedInputStream(this)
    def read() = buffer.read()
  }
}

object Exercise08 extends App {
  val file = new File("ch10ex08.txt")
  val pw = new PrintWriter(file)
  pw.print("Hello World!")
  pw.close()

  val is = new FileInputStream(file) with BufferedInputStream
  for (i <- 1 to 10) println(is.read().toChar)
  is.close()

  Files.deleteIfExists(file.toPath)
}
