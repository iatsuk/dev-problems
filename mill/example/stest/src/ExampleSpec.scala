import org.scalatest._
import flatspec._
import matchers._

class ExampleSpec extends AnyFlatSpec with should.Matchers {

  it should "passed" in {
    1 should be(1)
  }

  ignore should "ignored" in {
    1 should be(2)
  }
}
