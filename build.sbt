ThisBuild / scalaVersion := "2.13.8"

lazy val `pbt-talk` = project
  .in(file("."))
  .aggregate(pbt, talk)
  .dependsOn(pbt, talk)

lazy val pbt = project
  .in(file("modules/pbt"))

lazy val talk =
  project
    .in(file("modules/talk"))
    .enablePlugins(MdocPlugin)
    .settings(
      mdocIn := baseDirectory.value / "slides"
    )
    .dependsOn(pbt)
