package com.chrisdostert.shorturlsvc.dbadapter.tdk.testobjects

import com.chrisdostert.shorturlsvc.dbadapter.tables.row.ShortUrlsTableRow

trait ATestShortUrlsTableRow
  extends ATest {

  def withValues(
    id: Option[Long] = option.nonNull,
    target: String = string.nonNull
  ): ShortUrlsTableRow =
    new ShortUrlsTableRow(
      id = id,
      target = target
    )

  def nonNull: ShortUrlsTableRow =
    withValues()

}
