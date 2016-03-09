package com.chrisdostert.shorturlsvc.dbadapter.tables.row

case class ShortUrlsTableRow(
  id: Option[Long],
  target: String
)
