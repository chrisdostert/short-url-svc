package com.urlable.shorturlsvc.dbadapter.usecases

import java.net.URL

import com.urlable.shorturlsvc.core.models.ShortUrlView
import com.urlable.shorturlsvc.dbadapter.factories.ShortUrlTableRowFactory
import com.urlable.shorturlsvc.dbadapter.tables.ShortUrlsTable
import slick.driver.MySQLDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

private[dbadapter]
class CreateShortUrlUc(
  private val shortUrlTableRowFactory: ShortUrlTableRowFactory,
  private val database: Database
) {

  def execute(target: URL): Future[ShortUrlView] = {
    database.run[ShortUrlView](
      (TableQuery[ShortUrlsTable]
        .returning(
          TableQuery[ShortUrlsTable].map(_.id)
        ) += shortUrlTableRowFactory.construct(target))
        .map(_.get)
        .map(
          shortUrlId => new ShortUrlView(
            shortUrlId,
            target
          )
        )
    )

  }


}
