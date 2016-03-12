package com.chrisdostert.shorturlsvc.dbadapter

import java.net.URL

import com.chrisdostert.shorturlsvc.core.models.{ShortUrlId, ShortUrlView}

import scala.concurrent.Future

trait DbPort {

  def createShortUrl(target: URL): Future[ShortUrlView]

  def getShortUrlWithId(id: ShortUrlId): Future[ShortUrlView]

}
