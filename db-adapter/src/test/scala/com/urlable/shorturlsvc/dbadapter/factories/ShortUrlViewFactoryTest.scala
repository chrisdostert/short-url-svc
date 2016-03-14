package com.urlable.shorturlsvc.dbadapter.factories

import java.net.URL

import com.urlable.shorturlsvc.core.models.ShortUrlView
import com.urlable.shorturlsvc.dbadapter.tables.row.ShortUrlsTableRow
import com.urlable.shorturlsvc.dbadapter.tdk.testobjects.ATest
import com.urlable.shorturlsvc.core.tdk.BaseFunSpecTest

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
