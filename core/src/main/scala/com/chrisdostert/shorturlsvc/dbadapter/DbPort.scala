package com.chrisdostert.shorturlsvc.dbadapter

import java.net.URL

import com.chrisdostert.shorturlsvc.core.models.ShortUrlView

import scala.concurrent.Future

trait DbPort {

  def createShortUrl(target: URL): Future[ShortUrlView]

  def getShortUrlWithId(id: String): Future[ShortUrlView]

}
