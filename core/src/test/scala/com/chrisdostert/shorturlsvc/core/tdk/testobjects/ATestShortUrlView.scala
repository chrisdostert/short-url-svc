package com.chrisdostert.shorturlsvc.core.tdk.testobjects

import java.net.URL

import com.chrisdostert.shorturlsvc.core.models.ShortUrlView

trait ATestShortUrlView
  extends ATest {

  val nonNull: ShortUrlView =
    new ShortUrlView(
      id = ATest.string.nonEmpty,
      target = new URL("http://dummyurl.com")
    )

}
