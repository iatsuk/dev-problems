package example

import org.scalajs.dom.html
import scalatags.JsDom.all._

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("ScalaJSExample")
object ScalaJSExample {

  @JSExport
  def main(target: html.Div): Unit = {
    val (f, d) = ("fox", "dog")
    target.appendChild(
      div(
        h1("Hello World"),
        p(
          "The quick brown ", b(f),
          " jumps over the lazy ", i(d), "."
        )
      ).render
    )
  }
}
