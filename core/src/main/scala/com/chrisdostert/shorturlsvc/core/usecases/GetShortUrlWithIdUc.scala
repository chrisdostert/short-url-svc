package com.chrisdostert.shorturlsvc.core.usecases

import com.chrisdostert.shorturlsvc.core.models.{ShortUrlId, ShortUrlView}
import com.chrisdostert.shorturlsvc.dbadapter.DbPort

import scala.concurrent.Future

private[core]
class GetShortUrlWithIdUc(
  private val dbPort: DbPort
) {

  def execute(id: ShortUrlId): Future[ShortUrlView] =
    dbPort
      .getShortUrlWithId(id)

}
