package com.urlable.shorturlsvc.dbadapter.factories

import java.net.URL
import com.urlable.shorturlsvc.dbadapter.tables.row.ShortUrlsTableRow
import com.urlable.shorturlsvc.core.tdk.BaseFunSpecTest

class ShortUrlsTableRowFactoryTest
  extends BaseFunSpecTest {

  describe("construct(:CreateShortUrlReq)") {
    it("should return the expected object") {

      /** arrange **/

      val providedTarget = new URL("http://dummyurl.co")

      val expectedShortUrlTableRow =
        new ShortUrlsTableRow(
          id = None,
          target = providedTarget.toString
        )

      val objectUnderTest = new ShortUrlTableRowFactory()

      /** act **/
      val actualShortUrlTableRow =
        objectUnderTest.construct(target = providedTarget)

      /** assert **/
      assert(actualShortUrlTableRow == expectedShortUrlTableRow)

    }
  }

}
