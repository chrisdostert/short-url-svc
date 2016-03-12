package com.chrisdostert.shorturlsvc.restapi.json

import java.net.URL

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.chrisdostert.shorturlsvc.core.models.{ShortUrlId, ShortUrlView}
import com.chrisdostert.shorturlsvc.restapi.json.formats.{ShortUrlIdFormat, UrlFormat}
import spray.json._

trait JsonSupport
  extends SprayJsonSupport
    with DefaultJsonProtocol {

  implicit val urlFormat: RootJsonFormat[URL] = UrlFormat

  implicit val shortUrlIdFormat: RootJsonFormat[ShortUrlId] = ShortUrlIdFormat

  implicit val shortUrlViewFormat: RootJsonFormat[ShortUrlView] =
    jsonFormat2(ShortUrlView)

}

object JsonSupport extends JsonSupport
