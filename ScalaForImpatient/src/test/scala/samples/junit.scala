package samples

import org.junit.Assert._
import org.junit._

@Test
class AppTest {

  @Test
  def testOK() = assertTrue(true)

  @Test
  def sout(): Unit = {
    print("Hello World!")
    assertTrue(true)
  }

}


