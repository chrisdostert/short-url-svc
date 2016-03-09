package com.chrisdostert.shorturlsvc.dbadapter

import com.chrisdostert.shorturlsvc.dbadapter.factories.{ShortUrlTableRowFactory, ShortUrlViewFactory}
import com.chrisdostert.shorturlsvc.dbadapter.tables.ShortUrlsTable
import com.chrisdostert.shorturlsvc.dbadapter.usecases._
import com.softwaremill.macwire._
import slick.driver.MySQLDriver.api._

private[dbadapter]
class CompositionRoot(
  private val dbAdapterConfig: DbAdapterConfig
) {

  private val database: Database =
    Database.forDriver(
      new com.mysql.jdbc.Driver,
      dbAdapterConfig.url,
      dbAdapterConfig.username,
      dbAdapterConfig.password
    )


  private lazy val shortUrls = TableQuery[ShortUrlsTable]

  private lazy val shortUrlViewFactory = wire[ShortUrlViewFactory]

  private lazy val shortUrlTableRowFactory = wire[ShortUrlTableRowFactory]

  lazy val createShortUrlUc = wire[CreateShortUrlUc]

  lazy val getShortUrlWithIdUc = wire[GetShortUrlWithIdUc]

  lazy val dbMigrator = wire[DbMigrator]

}
