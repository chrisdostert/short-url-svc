package com.urlable.shorturlsvc.restapi.routes

import java.net.URL

import akka.http.scaladsl.server.Directives._
import com.urlable.shorturlsvc.restapi.json.JsonSupport
import com.urlable.shorturlsvc.core.Core

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
                complete{
                  core.createShortUrl(target)
                }
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
