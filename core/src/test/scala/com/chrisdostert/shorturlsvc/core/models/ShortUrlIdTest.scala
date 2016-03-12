package com.chrisdostert.shorturlsvc.core.models

import com.chrisdostert.shorturlsvc.core.tdk.BaseFunSpecTest

class ShortUrlIdTest
  extends BaseFunSpecTest {

  describe("companion object fromBase62String method") {
    it("constructs instance with expected value") {
      /** arrange **/

      val providedShortUrlId = "3D7"
      val expectedValue = 12345

      /** act **/
      val actualValue = ShortUrlId.fromBase62String(providedShortUrlId).value

      /** assert **/
      assert(actualValue == expectedValue)
    }
  }

  describe("companion object toBase62String method") {
    it("returns expected value") {
      /** arrange **/

      val shortUrlIdValue = 12345
      val expectedValue = "3D7"

      val providedShortUrlId = ShortUrlId.fromLong(shortUrlIdValue)

      /** act **/
      val actualValue = providedShortUrlId.toString

      /** assert **/
      assert(actualValue == expectedValue)
    }
  }

}
