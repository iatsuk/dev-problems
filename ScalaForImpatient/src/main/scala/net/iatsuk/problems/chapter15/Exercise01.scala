package net.iatsuk.problems.chapter15

import org.junit.Test
import org.junit.Test.None

class Exercise01 {

  @Test
  def test01(): Unit = {
    println("Test without arguments")
  }

  @Test(expected = classOf[None], timeout = 0L)
  def test02(): Unit = {
    println("Test with arguments")
  }

}
