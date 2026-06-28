import com.peknight.build.gav
import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val spire = (project in file("."))
  .settings(name := "spire")
  .aggregate(spireCore.projectRefs *)

lazy val spireCore = (projectMatrix in file("spire-core"))
  .settings(name := "spire-core")
  .settings(libraryDependencies ++= dependencies(typelevel.spire))
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))
