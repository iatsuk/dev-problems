package net.iatsuk.problems.chapter18

object Exercise02 extends App {

  object Show
  object Then
  object Around

  val show = Show
  val then = Then
  val around = Around

  trait FluentBug {
    this: Exercise01.Bug =>
    def turn(obj: Around.type): this.type = { turn(); this }
    def and(obj: Show.type ): this.type = { this.show(); this }
    def and(obj: Then.type ): this.type = this
  }


  val bugsy = new Exercise01.Bug with FluentBug
  bugsy move 4 and show and then move 6 and show turn around move 5 and show
}
