package ex1 {

  package com.horstman.impatient {

    import ex1.com.Z

    class A {
      val z = new Z()
      val b = new B()
    }

  }

  package com {

    class Z {}
    package horstman {
      package impatient {

        class B {
          val z = new Z()
          val a = new A()
        }

      }

    }

  }

}
