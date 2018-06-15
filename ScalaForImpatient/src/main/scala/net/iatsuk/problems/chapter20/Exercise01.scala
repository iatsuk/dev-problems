package net.iatsuk.problems.chapter20

import scala.actors.{Actor, Channel}
import scala.util.Random

object Exercise01 extends App {

  class SumActor extends Actor {
    override def act(): Unit = {
      react {
        case (a: Seq[Long], out: Actor) => out ! (a.sum, a.length)
      }
    }
  }

  class AggActor(partsCount: Int, out: Channel[Long]) extends Actor {
    private var processedParts = 0
    private var totalSum = 0L
    private var totalCount = 0

    def avg: Long = totalSum / totalCount

    override def act(): Unit = {
      react {
        case (sum: Long, count: Int) =>
          totalSum += sum
          totalCount += count
          processedParts += 1
          if (processedParts < partsCount) act() else out ! avg
      }
    }
  }

  Actor.actor {
    val startTime = System.currentTimeMillis()
    val partsCount = 10
    val numCount = 1000000
    val step = numCount / partsCount

    val a = for (i <- 0 until numCount) yield Random.nextLong()

    val result = new Channel[Long]
    val aggActor = new AggActor(partsCount, result).start()
    for (i <- 0 until partsCount) new SumActor().start() ! (a.slice(i * step, (i + 1) * step), aggActor)

    result.receive {
      case avg => printf("Avg: %d%nTime: %dms%n", avg, System.currentTimeMillis() - startTime)
    }
  }
}
