name := "macro-examples"

scalaVersion := "2.11.7"

lazy val macros = (Project("macros",file("macros")).settings())

lazy val demo = (Project("demo",file("demo")).dependsOn(macros).settings())

