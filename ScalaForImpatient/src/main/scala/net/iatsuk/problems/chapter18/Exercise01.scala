package net.iatsuk.problems.chapter18

object Exercise01 extends App {

  class Bug {
    private var pos = 0
    private var forward = true
    def move(steps: Int): this.type = { if (forward) pos += steps else pos -= steps; this }
    def turn(): this.type = { forward = !forward; this }
    def show(): this.type = { printf("%d ", pos); this }
  }

  val bugsy = new Bug
  bugsy.move(4).show().move(6).show().turn().move(5).show()
}
