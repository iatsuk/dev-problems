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

