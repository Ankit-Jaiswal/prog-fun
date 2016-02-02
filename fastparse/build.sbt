lazy val root = (project in file(".")).
  settings(
    name := "fastparse",
    version := "1.0",
    scalaVersion := "2.10.4",
		libraryDependencies += "com.lihaoyi" %% "fastparse" % "0.2.1"
  )
