package net.iatsuk.problems.chapter07

package level1 {

  class A {
    private[level1] val PI = 3.1415
  }

  class B {
    val a = new A
    a.PI
  }

  package level2 {

    class C {
      val a = new A
      a.PI
    }
  }
}

