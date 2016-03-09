package com.chrisdostert.shorturlsvc.dbadapter.usecases

import com.chrisdostert.shorturlsvc.core.models.ShortUrlView
import com.chrisdostert.shorturlsvc.dbadapter.factories.ShortUrlViewFactory
import com.chrisdostert.shorturlsvc.dbadapter.tables.ShortUrlsTable
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
    shortUrlId: String
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
