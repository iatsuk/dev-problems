package net.iatsuk.problems.chapter07

import java.util.{HashMap => JavaHashMap}
import scala.collection.mutable
import scala.collection.JavaConversions.mapAsScalaMap

object Exercise06 {

  def javaMap2ScalaMap(map: JavaHashMap[Any, Any]): mutable.Map[Any, Any] = {
    for ((k, v) <- map) yield (k, v)
  }

}
