import utest._

object HelloTests extends TestSuite {
  val tests = Tests {
    "pass" - {
      assert("1".toInt == 1)
    }
  }
}
