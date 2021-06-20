/** @see
  *   https://com-lihaoyi.github.io/mill/mill/Intro_to_Mill.html
  */
import mill._, scalalib._

object example extends ScalaModule {
  def scalaVersion = "3.0.0"

  // I think mUnit is the best for VSCode
  object mtest extends Tests with TestModule.Munit {
    def ivyDeps = Agg(ivy"org.scalameta::munit::0.7.26")
  }
  object utest extends Tests with TestModule.Utest {
    def ivyDeps = Agg(ivy"com.lihaoyi::utest::0.7.10")
  }
  object stest extends Tests with TestModule.ScalaTest {
    def ivyDeps = Agg(ivy"org.scalatest::scalatest::3.2.9")
  }
}
