package com.urlable.shorturlsvc.dbadapter.tables

import com.urlable.shorturlsvc.dbadapter.tables.row.ShortUrlsTableRow
import slick.driver.MySQLDriver.api._
import slick.lifted.{ProvenShape, Tag}

private[dbadapter]
class ShortUrlsTable(tag: Tag)
  extends Table[ShortUrlsTableRow](
    tag,
    "ShortUrls"
  ) {

  def id: Rep[Option[Long]] =
    column[Option[Long]](
      "Id",
      O.PrimaryKey,
      O.AutoInc
    )

  def target: Rep[String] =
    column[String](
      "Target"
    )


  def * : ProvenShape[ShortUrlsTableRow] = // scalastyle:off
    (id, target) <>(ShortUrlsTableRow.tupled, ShortUrlsTableRow.unapply)

}
