package net.iatsuk.problems.chapter07

object Exercise07 {

  import java.util.{HashMap => JavaHashMap}
  import scala.collection.mutable

  def javaMap2ScalaMap(map: JavaHashMap[Any, Any]): mutable.Map[Any, Any] = {
    import scala.collection.JavaConversions.mapAsScalaMap
    for ((k, v) <- map) yield (k, v)
  }

}
