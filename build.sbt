import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val spire = (project in file("."))
  .settings(name := "spire")
  .aggregate(
    spireCore.jvm,
    spireCore.js,
  )

lazy val spireCore = (crossProject(JVMPlatform, JSPlatform) in file("spire-core"))
  .settings(name := "spire-core")
  .settings(crossDependencies(typelevel.spire))

