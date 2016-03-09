package com.chrisdostert.shorturlsvc.restapi.routes

import java.net.URL

import akka.http.scaladsl.server.Directives._
import com.chrisdostert.shorturlsvc.core.Core
import com.chrisdostert.shorturlsvc.restapi.json.JsonSupport

private[restapi]
class ShortUrlsRoute(
  jsonSupport: JsonSupport,
  core: Core
) {

  import jsonSupport._

  val route =
    pathPrefix("short-urls") {
      pathEndOrSingleSlash {
        post {
          decodeRequest {
            entity(as[URL]) {
              target =>
                complete(
                  core.createShortUrl(target)
                )
            }
          }
        }

      } ~ pathPrefix(Segment) {
        id =>
          complete {
            core.getShortUrlWithId(id)
          }
      }

    }

}
