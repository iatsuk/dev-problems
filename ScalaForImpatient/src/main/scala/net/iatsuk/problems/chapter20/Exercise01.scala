package net.iatsuk.problems.chapter20

import scala.actors.{Actor, Channel, OutputChannel}
import scala.util.Random

object Exercise01 extends App {
  val startTime = System.currentTimeMillis()

  val partsCount = 1
  val numCount = 10000000
  val step = numCount / partsCount

  class SumActor extends Actor {
    override def act(): Unit = {
      react {
        case (a: Array[Long], out: OutputChannel[(Long, Int)]) => out ! (a.sum, a.length)
      }
    }
  }

  class AggActor extends Actor {
    private var processedParts = 0
    private var totalSum = 0L
    private var totalCount = 0

    def avg: Long = totalSum / totalCount

    override def act(): Unit = {
      while (processedParts < partsCount) {
        receive {
          case (sum: Long, count: Int) => totalSum += sum; totalCount += count; processedParts += 1
        }
      }
    }
  }

  val a = for (i <- 0 to numCount) yield Random.nextLong()

  val aggActor = new AggActor
  aggActor.start()
  val c = new Channel[(Long, Int)](aggActor)

  for (i <- 1 to partsCount) {
    val actor = new SumActor
    actor.start()
    actor ! (a.slice(i * step, (i + 1) * step), c)
    actor
  }

  while (aggActor.getState != Actor.State.Terminated) {}
  println(aggActor.avg)

  println(System.currentTimeMillis() - startTime)
}
