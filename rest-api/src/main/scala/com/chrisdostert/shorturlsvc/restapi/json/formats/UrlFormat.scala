package com.chrisdostert.shorturlsvc.restapi.json.formats

import java.net.URL

import com.chrisdostert.shorturlsvc.restapi.json.JsonSupport
import spray.json._

object UrlFormat
  extends JsonSupport
    with RootJsonFormat[URL] {

  override def read(json: JsValue): URL = {

    json match {
      case JsString(string) => new URL(string)
      case _ => throw new IllegalArgumentException(
        s"received invalid URL: ${json.compactPrint}"
      )
    }

  }

  override def write(obj: URL): JsValue =
    JsString(obj.toString)

}
