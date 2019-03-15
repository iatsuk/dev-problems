package example

import org.scalajs.dom.html
import scalatags.JsDom.all._
import org.scalajs.dom.ext._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("ScalaJSExample")
object ScalaJSExample {

  @JSExport
  def main(target: html.Div): Unit = {
    import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
    val url = "http://api.openweathermap.org/data/2.5/weather?q=Singapore&APPID=45b1c43605b577d1089b94749ca1533d"
    Ajax.get(url).onSuccess { case xhr =>
      target.appendChild(pre(xhr.responseText).render)
      if (xhr.status == 200) {
        val json = js.JSON.parse(xhr.responseText)
        val name = json.name.toString
        val weather = json.weather.pop().main.toString
        def celsius(kelvins: js.Dynamic) = {
          kelvins.asInstanceOf[Double] - 273.15
        }.toInt
        val min = celsius(json.main.temp_min)
        val max = celsius(json.main.temp_max)
        val humid = json.main.humidity.toString
        target.appendChild(
          div(
            b("Weather in Singapore"),
            ul(
              li(b("Country "), name),
              li(b("Weather "), weather),
              li(b("Temp "), min, " - ", max, " °C"),
              li(b("Humidity "), humid, "%")
            )
          ).render
        )
      }
    }
  }
}
