package com.chrisdostert.shorturlsvc.core.usecases

import java.net.URL

import com.chrisdostert.shorturlsvc.core.models.ShortUrlView
import com.chrisdostert.shorturlsvc.dbadapter.DbPort

import scala.concurrent.Future

private[core]
class CreateShortUrlUc(
  private val dbPort: DbPort
) {

  def execute(target: URL): Future[ShortUrlView] = {

    dbPort
      .createShortUrl(target = target)

  }


}
