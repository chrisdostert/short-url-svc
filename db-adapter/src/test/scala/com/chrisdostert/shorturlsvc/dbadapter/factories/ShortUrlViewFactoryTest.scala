package com.chrisdostert.shorturlsvc.dbadapter.factories

import java.net.URL

import com.chrisdostert.shorturlsvc.core.models.ShortUrlView
import com.chrisdostert.shorturlsvc.core.tdk.BaseFunSpecTest
import com.chrisdostert.shorturlsvc.dbadapter.tables.row.ShortUrlsTableRow
import com.chrisdostert.shorturlsvc.dbadapter.tdk.testobjects.ATest

class ShortUrlViewFactoryTest
  extends BaseFunSpecTest {

  describe("construct(:ShortUrlsTableRow)") {
    it("should return expected ShortUrlView") {

      /** arrange **/
      val providedShortUrlTableRow: ShortUrlsTableRow =
        ATest.shortUrlsTableRow.withValues(
          id = Some(ATest.long.nonNull),
          target = "http://someurl.co"
        )

      val expectedShortUrlView =
        new ShortUrlView(id = providedShortUrlTableRow.id.get.toString, target = new URL(providedShortUrlTableRow.target))

      val objectUnderTest =
        new ShortUrlViewFactory()

      /** act **/
      val actualShortUrlView =
        objectUnderTest
          .construct(providedShortUrlTableRow)

      /** assert **/
      assert(actualShortUrlView == expectedShortUrlView)
    }
  }

}
