package net.iatsuk.problems.chapter18

object Exercise03 extends App {

  sealed trait Action
  case object Title extends Action
  case object Author extends Action

  class Document {
    private var useNextArgAs: Action = _
    private var title = ""
    private var author = ""

    def set(obj: Action): this.type = { useNextArgAs = obj; this }

    def to(arg: String): this.type = useNextArgAs match {
      case Title => title = arg; this
      case Author => author = arg; this
    }

    override def toString = s"""Document(title="$title", author="$author")"""
  }

  val book = new Document
  book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
  println(book)
}
