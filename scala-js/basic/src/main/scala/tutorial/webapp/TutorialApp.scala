package tutorial.webapp

import org.querki.jquery._
import org.scalajs.dom
import org.scalajs.dom.document

object TutorialApp {
  def main(args: Array[String]): Unit = {
    $(() => setupUI())
  }

  def setupUI(): Unit = {
    $("body").append("<p>Hello World</p>")
    $("#click-me-button").click(() => addClickedMessage())
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button!")
  }
}
