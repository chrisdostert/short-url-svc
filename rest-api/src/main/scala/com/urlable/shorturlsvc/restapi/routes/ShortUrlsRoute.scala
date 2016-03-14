package com.urlable.shorturlsvc.restapi.routes

import java.net.URL

import akka.http.scaladsl.server.Directives._
import com.urlable.shorturlsvc.core.Core
import com.urlable.shorturlsvc.restapi.CorsSupport
import com.urlable.shorturlsvc.restapi.json.JsonSupport

private[restapi]
class ShortUrlsRoute(
  jsonSupport: JsonSupport,
  core: Core
) extends CorsSupport {

  import jsonSupport._

  val route =
    pathPrefix("short-urls") {
      cors {
        pathEndOrSingleSlash {
          post {
            decodeRequest {
              entity(as[URL]) {
                target =>
                  complete {
                    core.createShortUrl(target)
                  }
              }
            }
          }

        } ~ pathPrefix(Segment) {
          id =>
              get{
                  complete {
                    core.getShortUrlWithId(id)
                  }

              }
        }

      }
    }


}
