package com.chrisdostert.shorturlsvc.dbadapter.factories

import java.net.URL

import com.chrisdostert.shorturlsvc.dbadapter.tables.row.ShortUrlsTableRow

private[dbadapter]
class ShortUrlTableRowFactory {

  def construct(target: URL): ShortUrlsTableRow =
    new ShortUrlsTableRow(
      None,
      target.toString
    )

}
