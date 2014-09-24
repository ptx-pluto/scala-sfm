name := "scala-sfm"

// set the name of the project

version := "1.0"

organization := "com.websfm"

// set the Scala version used for the project
scalaVersion := "2.11.2"

// set the main Scala source directory to be <base>/src
scalaSource in Compile := baseDirectory.value / "src/main"

libraryDependencies += "io.spray" %% "spray-json" % "1.2.6"

libraryDependencies  ++= Seq(
  // other dependencies here
  "org.scalanlp" %% "breeze" % "0.8.1",
  // native libraries are not included by default. add this if you want them (as of 0.7)
  // native libraries greatly improve performance, but increase jar sizes.
  "org.scalanlp" %% "breeze-natives" % "0.8.1"
)

resolvers ++= Seq(
  // other resolvers here
  // if you want to use snapshot builds (currently 0.8-SNAPSHOT), use this.
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
)
