package net.iatsuk.problems.chapter22

import java.io.File

import scala.util.continuations._

object Exercise03 extends App {

  class FileListIterator(val dir: File) extends Iterator[Unit] {

    private var cont: (Unit => Unit) = null
    reset {
      processDirectory(new File("."))
    }

    private def processDirectory(dir: File): Unit @suspendable = {
      val files = dir.listFiles
      var i = 0
      while (i < files.length) {
        val f = files(i)
        i += 1
        if (f.isDirectory) {
          processDirectory(f)
        } else {
          shift{
            k: (Unit => Unit) => {
              cont = k
            }
          }
          println(f)
        }
      }
    }

    override def hasNext: Boolean = ???

    override def next(): Unit = cont()
  }

  val iter = new FileListIterator(new File("."))
  for (i <- 1 to 100) iter.next()
}
