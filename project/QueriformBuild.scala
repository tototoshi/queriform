import sbt._
import sbt.Keys._

object QueriformBuild extends Build {

  lazy val queriform = Project(
    id = "queriform",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "queriform",
      organization := "com.github.tototoshi",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.0",
      libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % "1.9.1" % "test"
      )
    )
  )
}
