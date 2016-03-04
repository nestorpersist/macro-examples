name := "macro-examples-demo"

organization := "com.persist"

version := "0.0.1"

scalaVersion := "2.11.7"

//scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-Ymacro-debug-lite")
scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")


//viewSettings

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.6.4" % "test"
)
