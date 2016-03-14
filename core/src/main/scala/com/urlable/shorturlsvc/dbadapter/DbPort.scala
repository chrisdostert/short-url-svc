package com.urlable.shorturlsvc.dbadapter

import java.net.URL

import com.urlable.shorturlsvc.core.models.{ShortUrlId, ShortUrlView}

import scala.concurrent.Future

trait DbPort {

  def createShortUrl(target: URL): Future[ShortUrlView]

  def getShortUrlWithId(id: ShortUrlId): Future[ShortUrlView]

}
