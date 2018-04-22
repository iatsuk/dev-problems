package net.iatsuk.problems.chapter10

import java.io.{File, FileInputStream, PrintWriter}
import java.nio.file.Files

trait IterableInputStream extends java.io.InputStream with Iterable[Byte] {

  override def iterator: Iterator[Byte] = new Iterator[Byte] {

    override def hasNext: Boolean = available() > 0

    override def next(): Byte = read().toByte
  }
}

object Exercise10 extends App {
  val file = new File("ch10ex10.txt")
  val pw = new PrintWriter(file)
  pw.print("Hello World!")
  pw.close()

  val is = new FileInputStream(file) with IterableInputStream
  for (c <- is) print(c.toChar)
  is.close()

  Files.deleteIfExists(file.toPath)
}
