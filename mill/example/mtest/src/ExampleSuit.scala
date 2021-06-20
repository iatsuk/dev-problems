import munit._

class ExampleSuite extends munit.FunSuite {
  test("ignored".ignore) {
    assertEquals(42, 43)
  }

  test("only".only) {
    assertEquals(42, 42)
  }

  test("filtered") {
    assertEquals(42, 42)
  }
}
