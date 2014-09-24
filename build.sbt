name := "scala-sfm"

// set the name of the project

version := "1.0"

organization := "com.websfm"

// set the Scala version used for the project
scalaVersion := "2.11.2"

// set the main Scala source directory to be <base>/src
scalaSource in Compile := baseDirectory.value / "src"

libraryDependencies += "io.spray" %% "spray-json" % "1.2.6"