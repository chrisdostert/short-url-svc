package com.urlable.shorturlsvc.core

import java.net.URL

import com.urlable.shorturlsvc.core.models._
import com.urlable.shorturlsvc.dbadapter.DbPort

import scala.concurrent.Future

class Core private[core](
  private val compositionRoot: CompositionRoot
) {

  def createShortUrl(target: URL): Future[ShortUrlView] =
    compositionRoot
      .createShortUrlUc
      .execute(target)

  def getShortUrlWithId(id: ShortUrlId): Future[ShortUrlView] =
    compositionRoot
      .getShortUrlWithIdUc
      .execute(id)

}

object Core {

  def apply(dBPort: DbPort): Core =
    new Core(new CompositionRoot(dBPort))

}
