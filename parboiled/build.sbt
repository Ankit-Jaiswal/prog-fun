lazy val root = (project in file(".")).
  settings(
    name := "Parboiled2",
    version := "0.1.0",
    scalaVersion := "2.11.7",
	libraryDependencies += "org.parboiled" %% "parboiled" % "2.1.0"
  )
