package com.chrisdostert.shorturlsvc.restapi

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.directives.DebuggingDirectives
import akka.stream.ActorMaterializer
import com.chrisdostert.shorturlsvc.core.Core

class ReSTApi(
  private val core: Core
) {

  implicit val system =
    ActorSystem("short-url-svc")

  implicit val actorMaterializer = ActorMaterializer()

  implicit val dispatcher = system.dispatcher

  val compositionRoot: CompositionRoot =
    new CompositionRoot(
      core = core,
      system = system
    )

  val routeWithLogging =
    DebuggingDirectives.logRequestResult(
      "",
      Logging.InfoLevel
    )(
      compositionRoot.shortUrlsRoute.route
    )

  val bindToInterface = "0.0.0.0"
  val bindToPort = 8080

  val bindingFuture =
    Http()
      .bindAndHandle(
        handler = routeWithLogging,
        interface = bindToInterface,
        port = bindToPort
      )

}
