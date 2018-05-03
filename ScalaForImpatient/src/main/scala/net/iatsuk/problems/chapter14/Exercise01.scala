package net.iatsuk.problems.chapter14

import java.io.File

import scala.io.Source

object Exercise01 extends App {
  val startTime = System.currentTimeMillis()

  def getJavaFilesRec(javaSrcDir: File): Set[String] = {
    val subDirClasses = javaSrcDir.listFiles.filter(_.isDirectory).flatMap(getJavaFilesRec)
    val paths = javaSrcDir.listFiles.filter(_.isFile).filter(_.toString.endsWith(".java")).map(_.toPath.toAbsolutePath.toString).toSet
    paths ++ subDirClasses
  }

  val javaSrcDir = new File("/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/src")
  if (!javaSrcDir.exists()) throw new RuntimeException("Java source dir is not valid")

  val caseRegExp = "case [^:]+:".r
  val thrusRegExp = "//.*alls?.*thr".r
  val stat = getJavaFilesRec(javaSrcDir).toStream
    .flatMap(Source.fromFile(_).getLines())
    .foldLeft(Map[String, Int]()) { (map, line) =>
      map + (
        "case" -> map.getOrElse("case", 0).+(caseRegExp.findAllMatchIn(line).length),
        "throw" -> map.getOrElse("throw", 0).+(thrusRegExp.findAllMatchIn(line).length)
      )
    }

  printf("Falls through comments: %d\n" + // 230
    "Total cases: %d\n" + // 10488
    "Percent of falls per cases: %.2f%%\n", // 2.19
    stat("throw"), stat("case"), 100.0 * stat("throw") / stat("case"))

  printf("\nProcessing time: %dms\n", System.currentTimeMillis() - startTime)
}
