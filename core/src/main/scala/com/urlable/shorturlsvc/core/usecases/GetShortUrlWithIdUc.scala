package com.urlable.shorturlsvc.core.usecases

import com.urlable.shorturlsvc.core.models.{ShortUrlId, ShortUrlView}
import com.urlable.shorturlsvc.dbadapter.DbPort

import scala.concurrent.Future

private[core]
class GetShortUrlWithIdUc(
  private val dbPort: DbPort
) {

  def execute(id: ShortUrlId): Future[ShortUrlView] =
    dbPort
      .getShortUrlWithId(id)

}
