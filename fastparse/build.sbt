lazy val root = (project in file(".")).
  settings(
    name := "fastparse",
    version := "0.1.0",
    scalaVersion := "2.11.7",
    libraryDependencies += "com.lihaoyi" %% "fastparse" % "0.2.1"
  )
