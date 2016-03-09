package com.chrisdostert.shorturlsvc.dbadapter.tdk.testobjects

private[dbadapter]
trait ATest
  extends com.chrisdostert.shorturlsvc.core.tdk.testobjects.ATest {

  lazy val shortUrlsTableRow =
    new ATestShortUrlsTableRow {}

}

private[dbadapter]
object ATest extends ATest
