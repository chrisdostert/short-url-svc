package com.urlable.shorturlsvc.dbadapter.usecases

import com.urlable.shorturlsvc.core.models.{ShortUrlId, ShortUrlView}
import com.urlable.shorturlsvc.dbadapter.tables.ShortUrlsTable
import com.urlable.shorturlsvc.dbadapter.factories.ShortUrlViewFactory
import slick.driver.MySQLDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

private[dbadapter]
class GetShortUrlWithIdUc(
  private val database: Database,
  private val shortUrls: TableQuery[ShortUrlsTable],
  private val shortUrlViewFactory: ShortUrlViewFactory
) {

  def execute(
    shortUrlId: ShortUrlId
  ): Future[ShortUrlView] = {

    val shortUrlQuery =
      shortUrls
        .filter(_.id === shortUrlId.toLong)
        .result
        .head
        .map(shortUrlViewFactory.construct)

    database
      .run(
        shortUrlQuery
      )

  }

}
