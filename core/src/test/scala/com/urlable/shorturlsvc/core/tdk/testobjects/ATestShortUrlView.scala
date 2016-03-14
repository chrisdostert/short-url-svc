package com.urlable.shorturlsvc.core.tdk.testobjects

import java.net.URL

import com.urlable.shorturlsvc.core.models.{ShortUrlId, ShortUrlView}

trait ATestShortUrlView
  extends ATest {

  def withValues(
    id: ShortUrlId = ATest.string.nonEmpty,
    target: URL = new URL("http://dummyurl.com")
  ): ShortUrlView =
    ShortUrlView(
      id,
      target
    )

  val nonNull: ShortUrlView = withValues()

}
