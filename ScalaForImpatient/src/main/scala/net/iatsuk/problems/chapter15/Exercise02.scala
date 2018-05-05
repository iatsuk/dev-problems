package net.iatsuk.problems.chapter15

class Exercise02 {

  @deprecated
  def justDeprecated(): Unit = ()

  @deprecated(message = "message")
  def messageDeprecated(): Unit = ()

  @deprecated(since = "1.0-SNAPSHOT")
  def sinceDeprecated(): Unit = ()

  @deprecated(message = "message", since = "1.0-SNAPSHOT")
  def mesAndSinDeprecated(): Unit = ()

  @deprecated(since = "1.0-SNAPSHOT", message = "message")
  def sinAndMesDeprecated(): Unit = ()

  @deprecated("message")
  def autoMesSinDeprecated(): Unit = ()

  @deprecated("message", "1.0-SNAPSHOT")
  def autoMesAndSinDeprecated(): Unit = ()
}
