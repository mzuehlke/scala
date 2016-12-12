scalacOptions ++= Seq("-unchecked", "-feature", /*"-deprecation",*/
  "-Xlint" /*, "-Xfatal-warnings"*/)

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.3.2"

libraryDependencies += "org.pantsbuild" % "jarjar" % "1.6.3"

libraryDependencies += "biz.aQute" % "bndlib" % "1.50.0"

enablePlugins(BuildInfoPlugin)

// configure sbt-buildinfo to send the externalDependencyClasspath to the main build, which allows using it for the IntelliJ project config

lazy val buildClasspath = taskKey[String]("Colon-separated list of entries on the sbt build classpath.")

buildClasspath := (externalDependencyClasspath in Compile).value.map(_.data).mkString(":")

buildInfoKeys := Seq[BuildInfoKey](buildClasspath)

buildInfoPackage := "scalabuild"

libraryDependencies += "com.typesafe" %% "mima-reporter" % "0.1.13"
