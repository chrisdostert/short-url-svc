package com.chrisdostert.shorturlsvc.core

import com.chrisdostert.shorturlsvc.core.usecases._
import com.chrisdostert.shorturlsvc.dbadapter.DbPort
import com.softwaremill.macwire._

class CompositionRoot(
  private val dbPort: DbPort
) {

  val createShortUrlUc = wire[CreateShortUrlUc]

  val getShortUrlWithId = wire[GetShortUrlWithIdUc]

}
