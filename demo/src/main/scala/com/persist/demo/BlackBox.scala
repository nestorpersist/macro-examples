package com.persist.demo

import com.persist.macros.BlackBox._
import com.persist.macros.SourceLocation

object BlackBox {
  case class Foo () {
  def foo(): Unit = {
    println(s"f=${sourceLocation()}")
  }

  }


  def main(args: Array[String]): Unit = {
    println(s"m=${sourceLocation()}")
    Foo().foo()
  }

}
