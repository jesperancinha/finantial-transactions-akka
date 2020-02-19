scalaVersion := "2.12.4"

name := "cake-maker"
organization := "org.jesperancinha.baker"
version := "1.0"

libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
libraryDependencies += "com.ing.baker" %% "baker-recipe-dsl" % "3.0.1"
libraryDependencies += "com.ing.baker" %% "baker-runtime" % "3.0.1"
libraryDependencies += "com.ing.baker" %% "baker-compiler" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % Test
