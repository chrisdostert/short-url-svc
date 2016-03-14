package com.urlable.shorturlsvc.restapi

import akka.actor.ActorSystem
import com.softwaremill.macwire._
import com.urlable.shorturlsvc.core.Core
import com.urlable.shorturlsvc.restapi.json.JsonSupport
import com.urlable.shorturlsvc.restapi.routes.ShortUrlsRoute

private[restapi]
class CompositionRoot(
  val core: Core,
  val system: ActorSystem
) {

  val jsonSupport = JsonSupport

  val shortUrlsRoute: ShortUrlsRoute = wire[ShortUrlsRoute]

}
