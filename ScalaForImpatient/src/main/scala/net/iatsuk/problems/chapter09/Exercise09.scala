package net.iatsuk.problems.chapter09

import java.io.File

object Exercise09 extends App {
  def calcClassFilesRecursively(dir: File): Int = {
    val subDirClasses = for (d <- dir.listFiles.filter(_.isDirectory)) yield calcClassFilesRecursively(d)
    dir.listFiles().filter(_.isFile).count(_.toString.endsWith(".class")) + subDirClasses.sum
  }

  val dir = new File("ScalaForImpatient/target")
  println(calcClassFilesRecursively(dir))
}
