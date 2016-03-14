package com.urlable.shorturlsvc.core

import com.softwaremill.macwire._
import com.urlable.shorturlsvc.core.usecases.{GetShortUrlWithIdUc, _}
import com.urlable.shorturlsvc.dbadapter.DbPort

private[core]
class CompositionRoot(
  private val dbPort: DbPort
) {

  val createShortUrlUc = wire[CreateShortUrlUc]

  val getShortUrlWithIdUc = wire[GetShortUrlWithIdUc]

}
