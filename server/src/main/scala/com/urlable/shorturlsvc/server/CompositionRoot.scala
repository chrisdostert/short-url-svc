package com.urlable.shorturlsvc.server

import com.urlable.shorturlsvc.dbadapter.DbAdapter
import com.urlable.shorturlsvc.restapi.ReSTApi
import com.softwaremill.macwire._
import com.typesafe.config.{Config, ConfigFactory}
import com.urlable.shorturlsvc.core.Core
import com.urlable.shorturlsvc.dbadapter.DbAdapterConfig
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ArbitraryTypeReader._

private[shorturlsvc]
class CompositionRoot {

  private val config: Config =
    ConfigFactory.load()

  private val dbAdapterConfig: DbAdapterConfig =
    config.as[DbAdapterConfig](DbAdapterConfig.HOCON_PATH)

  private lazy val dbAdapter = wire[DbAdapter]

  private lazy val core: Core = wire[Core]

  lazy val restApi: ReSTApi = wire[ReSTApi]

}
