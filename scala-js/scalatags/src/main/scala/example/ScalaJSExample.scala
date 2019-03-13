package example

import org.scalajs.dom
import org.scalajs.dom.html
import scalatags.JsDom.all._

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("ScalaJSExample")
object ScalaJSExample {

  @JSExport
  def main(target: html.Div): Unit = {
    // hello world
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

    // user input
    val box = input(
      `type` := "text",
      placeholder := "Type here!"
    ).render

    val output = span.render

    box.onkeyup = (e: dom.Event) => {
      output.textContent = box.value.toUpperCase
    }

    target.appendChild(
      div(
        h1("Capital Box!"),
        p("Type here and have it capitalized!"),
        div(box),
        div(output)
      ).render
    )

    // re-rendering
    val listings = Seq(
      "Apple", "Apricot", "Banana", "Cherry", "Mango", "Mangosteen", "Mandarin", "Grape", "Grapefruit", "Guava"
    )

    val box2 = input(`type` := "text", placeholder := "Type here!").render

    def renderListings = ul(
      for {
        fruit <- listings
        if fruit.toLowerCase.startsWith(box2.value.toLowerCase)
      } yield { //li(fruit)
        val (first, last) = fruit.splitAt(box2.value.length)
        li(
          span(backgroundColor:="yellow", first),
          last
        )
      }
    ).render

    val output2 = div(renderListings).render

    box2.onkeyup = (e: dom.Event) => {
      output2.innerHTML = ""
      output2.appendChild(renderListings)
    }

    target.appendChild(
      div(
        h1("Search box!"),
        p("Type here to filter the list of things below!"),
        div(box2),
        output2
      ).render
    )
  }
}
