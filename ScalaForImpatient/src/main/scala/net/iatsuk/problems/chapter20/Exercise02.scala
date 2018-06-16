package net.iatsuk.problems.chapter20

import java.awt.image.BufferedImage
import java.io.File
import java.net.URL

import javax.imageio.ImageIO

import scala.actors.Actor

object Exercise02 extends App {

  class InvertActor extends Actor {
    override def act(): Unit = {
      react {
        case tile: BufferedImage =>
          for (x <- 0 until tile.getWidth; y <- 0 until tile.getHeight) tile.setRGB(x, y, 0xFFFFFF - tile.getRGB(x, y))
      }
    }
  }

  Actor.actor {
    val tiles = 4
    val actors = new Array[Actor](tiles)

    val image = ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/commons/a/aa/Vincent_van_Gogh_-_Self-portrait_with_grey_felt_hat_-_Google_Art_Project.jpg"))
    printf("image width: %d%nimage height: %d%n", image.getWidth, image.getHeight)


    val start = System.currentTimeMillis()
    val offset = image.getHeight / tiles
    for (tile <- 0 until tiles) {
      val img = image.getSubimage(0, tile * offset, image.getWidth, offset)
      actors(tile) = new InvertActor().start()
      actors(tile) ! image.getSubimage(0, tile * offset, image.getWidth, offset)
    }

    while (actors.map(_.getState == Actor.State.Terminated).reduce(_ | _)) {}

    ImageIO.write(image, "jpg", new File("out.jpg"))
    printf("Processing time: %d%n", System.currentTimeMillis() - start)
  }
}
