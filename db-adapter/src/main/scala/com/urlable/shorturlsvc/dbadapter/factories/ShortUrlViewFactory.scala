package com.urlable.shorturlsvc.dbadapter.factories

import java.net.URL

import com.urlable.shorturlsvc.core.models.ShortUrlView
import com.urlable.shorturlsvc.dbadapter.tables.row.ShortUrlsTableRow

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
