package net.iatsuk.problems.chapter20

import scala.actors.{Actor, Channel}
import scala.util.Random

object Exercise10 extends App {

  class SumActor extends Actor {
    override def act(): Unit = {
      react {
        case (a: Seq[Long], out: Channel[(Long, Int)]) => out ! (a.sum, a.length)
      }
    }
  }

  class AggActor(partsCount: Int) extends Actor {
    private var processedParts = 0
    private var totalSum = 0L
    private var totalCount = 0

    val channel = new Channel[(Long, Int)](this)

    def avg: Long = totalSum / totalCount

    override def act(): Unit = {
      while (processedParts < partsCount) {
        channel.receive {
          case (sum, count) =>
            totalSum += sum
            totalCount += count
            processedParts += 1
        }
      }

      react {
        case "avg" => sender ! avg
      }
    }
  }

  val startTime = System.currentTimeMillis()
  val partsCount = 10
  val numCount = 1000000
  val step = numCount / partsCount

  val aggActor = new AggActor(partsCount).start().asInstanceOf[AggActor]
  val a = for (i <- 0 until numCount) yield Random.nextLong()
  for (i <- 0 until partsCount) new SumActor().start() ! (a.slice(i * step, (i + 1) * step), aggActor.channel)

  val avg = (aggActor !? "avg").asInstanceOf[Long]
  printf("Avg: %d%nTime: %dms%n", avg, System.currentTimeMillis() - startTime)
}
