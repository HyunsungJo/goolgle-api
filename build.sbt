name := """goolgle-api"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "com.sksamuel.elastic4s" %% "elastic4s" % "1.4.0",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.4.1",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.1",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.4.1",
  jdbc,
  anorm,
  cache,
  ws
)
