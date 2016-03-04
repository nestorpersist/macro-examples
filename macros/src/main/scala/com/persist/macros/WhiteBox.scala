package com.persist.macros

import scala.language.reflectiveCalls
import scala.language.existentials

object WhiteBox {
  import scala.language.experimental.macros
  import scala.reflect.macros.whitebox.Context

  def mix[T](tf: T): Any = macro mixMacro[T]

  def mixMacro[T: c.WeakTypeTag](c: Context)(tf: c.Expr[Any]): c.Expr[Any] = {
    import c.universe._

    val x = c.weakTypeTag[T]
    val name = x.tpe.toString
    if (name == "Int") {
      c.Expr[Int](q"$tf + 2")
    } else if (name == "String") {
      val s = "String:"
      c.Expr[String] (q"$s + $tf")
    } else {
      val names = x.tpe.decls
        .filter { case d => d.isMethod && d.toString.startsWith("value ") }
        .map(_.name).toSeq
      val decls = names map { case n =>
        val t = TermName(n.toString)
        q"""$t:Int"""
      }
      val vals = (0 until names.size).map(_+6).toSeq
      val q1 =
        q"""
             case class Foo(..$decls)
             Foo(..$vals)
        """
      c.Expr(q1)
    }
  }
}
