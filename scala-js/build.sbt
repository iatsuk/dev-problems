ThisBuild / version := "1.0.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "net.iatsuk"

lazy val basic = (project in file("basic"))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "Scala.js Tutorial",

    scalaJSUseMainModuleInitializer := true,
    jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv(),
    skip in packageJSDependencies := false,
    jsDependencies += "org.webjars" % "jquery" % "2.2.1" / "jquery.js" minified "jquery.min.js",

    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6",
    libraryDependencies += "org.querki" %%% "jquery-facade" % "1.2",
    libraryDependencies += "com.lihaoyi" %%% "utest" % "0.6.3" % "test",
    testFrameworks += new TestFramework("utest.runner.Framework"),
  )

lazy val workbench = (project in file("workbench"))
  .enablePlugins(ScalaJSPlugin, WorkbenchPlugin)
  .settings(
      name := "Workbench Example App by Hands-on Scala.js",
      libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6",
      libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.6.7",
  )

lazy val sketchpad = (project in file("sketchpad"))
  .enablePlugins(ScalaJSPlugin, WorkbenchPlugin)
  .settings(
    name := "Sketchpad",
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6",
    libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.6.7",
  )

lazy val clock = (project in file("clock"))
  .enablePlugins(ScalaJSPlugin, WorkbenchPlugin)
  .settings(
    name := "Clock",
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6",
    libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.6.7",
  )

lazy val flappybox = (project in file("flappybox"))
  .enablePlugins(ScalaJSPlugin, WorkbenchPlugin)
  .settings(
    name := "Flappy Bird",
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6",
    libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.6.7",
  )

lazy val html = (project in file("html"))
  .enablePlugins(ScalaJSPlugin, WorkbenchPlugin)
  .settings(
    name := "html",
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6",
    libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.6.7",
  )

lazy val scalatags = (project in file("scalatags"))
  .enablePlugins(ScalaJSPlugin, WorkbenchPlugin)
  .settings(
    name := "scalatags",
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6",
    libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.6.7",
  )

lazy val webservices = (project in file("webservices"))
  .enablePlugins(ScalaJSPlugin, WorkbenchPlugin)
  .settings(
    name := "webservices",
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6",
    libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.6.7",
  )
