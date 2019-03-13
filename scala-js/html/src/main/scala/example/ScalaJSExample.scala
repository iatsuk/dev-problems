package example

import org.scalajs.dom
import dom.html

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("ScalaJSExample")
object ScalaJSExample {

  @JSExport
  def main(target: html.Div): Unit = {
    val (f, d) = ("fox", "dog")
    target.innerHTML =
      s"""
         |<div>
         |  <h1>Hello World</h1>
         |  <p>
         |    The quick brown <b>$f</b>
         |    jumps over the lazy <b>$d</b>
         |  </p>
         |</div>
       """.stripMargin
  }
}
