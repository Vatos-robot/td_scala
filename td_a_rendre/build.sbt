import Dependencies._

ThisBuild / scalaVersion     := "2.12.15"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "td_a_rendre",
    libraryDependencies += munit % Test
  )
libraryDependencies += "com.github.scopt" %% "scopt" % "4.0.1"
// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
