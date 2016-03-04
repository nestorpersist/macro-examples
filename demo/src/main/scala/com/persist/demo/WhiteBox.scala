package com.persist.demo

import com.persist.macros.WhiteBox._
import scala.language.reflectiveCalls
import scala.reflect.runtime.universe._
import scala.language.existentials

object WhiteBox {

  def debug[T: TypeTag](x: T): Unit = {
    println(s"$x:${x.getClass}")
    for (d <- typeTag[T].tpe.decls) {
      if (d.toString.startsWith("value ") && d.info.toString.startsWith("=>")){
        println(s"   ${d.name} ${d.info}")
      }
    }
  }

  case class Test(a: Int, b: String)

  def main(args: Array[String]): Unit = {
    println("***************")
    val x = mix(35)
    debug(x)
    println("***************")
    val y = mix("foo!!")
    debug(y)
    println("***************")
    val t = Test(3, "bar")
    val z = mix(t)
    debug(z)
    println()
    println(s"   a = ${z.a}")
    println(s"   b = ${z.b}")
  }

}
