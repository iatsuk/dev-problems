package net.iatsuk.problems.chapter14

import java.io.File

import scala.io.Source

object Exercise01 extends App {
  def getJavaFilesRec(javaSrcDir: File): Set[String] = {
    val subDirClasses = for (d <- javaSrcDir.listFiles.filter(_.isDirectory)) yield getJavaFilesRec(d)
    val paths = javaSrcDir.listFiles().filter(_.isFile).filter(_.toString.endsWith(".java")).map(_.toPath.toAbsolutePath.toString).toSet
    paths ++ subDirClasses.reduceLeftOption(_ ++ _).getOrElse(Set())
  }

  val javaSrcDir = new File("/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/src")
  if (!javaSrcDir.exists()) throw new RuntimeException("Java source dir is not valid")
  val stream = getJavaFilesRec(javaSrcDir).toStream.flatMap(Source.fromFile(_).getLines())

  val cases = stream.count("case [^:]+:".r.findFirstMatchIn(_).isDefined)
  val thrus = stream.count("//.*alls?.*thr".r.findFirstMatchIn(_).isDefined)

  printf("Falls through comments: %d\n" + // 230
    "Total cases: %d\n" + // 10099
    "Percent of falls per cases: %.2f%%", // 2.28
    thrus, cases, 100.0 * thrus / cases)
}
