

class HelloSpec extends FunSuite with DiagrammedAssertions {
  test("Hello should stats with H") {
    assert("Hello".startsWith("H"))
  }
}
