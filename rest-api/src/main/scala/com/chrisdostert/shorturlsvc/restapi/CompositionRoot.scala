package com.chrisdostert.shorturlsvc.restapi

import akka.actor.ActorSystem
import com.chrisdostert.shorturlsvc.core.Core
import com.chrisdostert.shorturlsvc.restapi.json.JsonSupport
import com.chrisdostert.shorturlsvc.restapi.routes.ShortUrlsRoute
import com.softwaremill.macwire._

private[restapi]
class CompositionRoot(
  val core: Core,
  val system: ActorSystem
) {

  val jsonSupport = new JsonSupport {}

  val shortUrlsRoute: ShortUrlsRoute = wire[ShortUrlsRoute]

}
