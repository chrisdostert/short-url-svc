packageName := "short-url-svc"

enablePlugins(DockerPlugin)

dockerBaseImage := "java:8u72-jre"
dockerExposedPorts += 8080

// assembly plugin
mainClass in Compile := Some("com.chrisdostert.shorturlsvc.server.Server")
