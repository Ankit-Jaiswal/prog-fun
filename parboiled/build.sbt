lazy val root = (project in file(".")).
  settings(
    name := "Parboiled2",
    version := "1.0",
    scalaVersion := "2.10.4",
	libraryDependencies += "org.parboiled" %% "parboiled" % "2.1.0"
  )
