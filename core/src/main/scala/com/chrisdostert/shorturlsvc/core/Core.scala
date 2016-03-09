package com.chrisdostert.shorturlsvc.core

import java.net.URL

import com.chrisdostert.shorturlsvc.core.models._
import com.chrisdostert.shorturlsvc.dbadapter.DbPort

import scala.concurrent.Future

class Core private[core](
  private val compositionRoot: CompositionRoot
) {

  def createShortUrl(target: URL): Future[ShortUrlView] =
    compositionRoot
      .createShortUrlUc
      .execute(target)

  def getShortUrlWithId(id: String): Future[ShortUrlView] =
    compositionRoot
      .getShortUrlWithId
      .execute(id)

}

object Core {

  def apply(dBPort: DbPort): Core =
    new Core(new CompositionRoot(dBPort))

}
