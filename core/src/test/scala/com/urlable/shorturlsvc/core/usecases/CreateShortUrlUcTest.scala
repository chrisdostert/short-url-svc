package com.urlable.shorturlsvc.core.usecases

import java.net.URL
import com.urlable.shorturlsvc.core.tdk.testobjects.ATest
import com.urlable.shorturlsvc.core.tdk.BaseFunSpecTest
import com.urlable.shorturlsvc.dbadapter.DbPort
import org.mockito.Mockito._

import scala.concurrent.Future

class CreateShortUrlUcTest
  extends BaseFunSpecTest {

  describe("execute") {

    it("should invoke dbPort.createShortUrl and return result") {

      /** arrange **/
      val providedTarget = new URL("http:dummyurl.co")

      val expectedReturnedFutureShortUrlView = Future.successful(ATest.shortUrlView.nonNull)

      val mockDbPort = mock[DbPort]
      when(mockDbPort.createShortUrl(providedTarget))
        .thenReturn(expectedReturnedFutureShortUrlView)

      val objectUnderTest = new CreateShortUrlUc(
        mockDbPort
      )

      /** act **/
      val actualReturnedFutureShortUrlView =
        objectUnderTest
                  .execute(providedTarget)

      /** assert **/
      assert(actualReturnedFutureShortUrlView == expectedReturnedFutureShortUrlView)

    }
  }

}
