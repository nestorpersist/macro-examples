name := "macro-examples-macros"

organization := "com.persist"

version := "0.0.1"

scalaVersion := "2.11.7"

//scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-Ymacro-debug-lite")
scalacOptions ++= Seq("-deprecation", "-unchecked")

//viewSettings

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "org.specs2" %% "specs2-core" % "3.6.4" % "test"
)
