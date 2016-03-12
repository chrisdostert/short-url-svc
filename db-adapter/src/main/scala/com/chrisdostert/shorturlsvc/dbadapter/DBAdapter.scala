package com.chrisdostert.shorturlsvc.dbadapter

import java.net.URL

import com.chrisdostert.shorturlsvc.core.models.{ShortUrlId, ShortUrlView}

import scala.concurrent.Future

class DbAdapter private[dbadapter](
  private val compositionRoot: CompositionRoot
)
  extends DbPort {

  compositionRoot.dbMigrator.migrate()

  def createShortUrl(target: URL): Future[ShortUrlView] =
    compositionRoot
      .createShortUrlUc
      .execute(target)

  def getShortUrlWithId(id: ShortUrlId): Future[ShortUrlView] =
    compositionRoot
      .getShortUrlWithIdUc
      .execute(id)

}

object DbAdapter {

  def apply(dBAdapterConfig: DbAdapterConfig): DbAdapter = {
    new DbAdapter(compositionRoot = new CompositionRoot(dBAdapterConfig))
  }


}
