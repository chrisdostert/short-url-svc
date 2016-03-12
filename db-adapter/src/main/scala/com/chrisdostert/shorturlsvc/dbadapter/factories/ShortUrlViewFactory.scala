package com.chrisdostert.shorturlsvc.dbadapter.factories

import java.net.URL

import com.chrisdostert.shorturlsvc.core.models.ShortUrlView
import com.chrisdostert.shorturlsvc.dbadapter.tables.row.ShortUrlsTableRow

private[dbadapter]
class ShortUrlViewFactory {

  def construct(
    shortUrlTableRow: ShortUrlsTableRow
  ): ShortUrlView =
    new ShortUrlView(
      id = shortUrlTableRow.id.get,
      target = new URL(shortUrlTableRow.target)
    )

}
