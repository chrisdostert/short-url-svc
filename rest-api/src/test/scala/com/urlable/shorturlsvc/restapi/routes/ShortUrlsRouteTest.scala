package com.urlable.shorturlsvc.restapi.routes

import java.net.URL

import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.urlable.shorturlsvc.core.Core
import com.urlable.shorturlsvc.core.models.ShortUrlView
import com.urlable.shorturlsvc.core.tdk.BaseFunSpecTest
import com.urlable.shorturlsvc.core.tdk.testobjects.ATest
import com.urlable.shorturlsvc.restapi.json.JsonSupport
import org.mockito.Mockito._

import scala.concurrent.Future

class ShortUrlsRouteTest
  extends BaseFunSpecTest
    with ScalatestRouteTest {

  private val shortUrlsBasePath = "/short-urls"
  private val jsonSupport = new JsonSupport {}

  import jsonSupport._

  describe(s"GET $shortUrlsBasePath/:id") {

    it("should return the result from core.getShortUrlWithId") {

      /** arrange **/
      val shortUrlReturnedFromCore =
        ATest.shortUrlView.nonNull

      val providedShortUrlId =
        ATest.string.nonEmpty

      val mockCore = mock[Core]
      when(mockCore.getShortUrlWithId(providedShortUrlId))
        .thenReturn(Future.successful(shortUrlReturnedFromCore))

      val objectUnderTest =
        new ShortUrlsRoute(
          jsonSupport,
          mockCore
        )

      /** act/assert **/
      Get(
        s"$shortUrlsBasePath/$providedShortUrlId"
      ) ~>
        objectUnderTest.route ~>
        check {
          responseAs[ShortUrlView] shouldEqual shortUrlReturnedFromCore
        }

    }
  }

  describe(s"POST $shortUrlsBasePath") {

    it("call core and return the result") {

      /** arrange **/
      val shortUrlReturnedFromCore =
        ATest.shortUrlView.nonNull

      val providedTarget = new URL("http://dummyurl.co")

      val mockCore = mock[Core]
      when(mockCore.createShortUrl(providedTarget))
        .thenReturn(Future.successful(shortUrlReturnedFromCore))

      val objectUnderTest =
        new ShortUrlsRoute(
          jsonSupport,
          mockCore
        )

      /** act/assert **/
      Post(
        shortUrlsBasePath,
        providedTarget
      ) ~>
        objectUnderTest.route ~>
        check {
          responseAs[ShortUrlView] shouldEqual shortUrlReturnedFromCore
        }

    }

  }

}
