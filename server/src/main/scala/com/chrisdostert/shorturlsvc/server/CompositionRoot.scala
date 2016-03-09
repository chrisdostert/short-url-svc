package com.chrisdostert.shorturlsvc.server

import com.chrisdostert.shorturlsvc.core.Core
import com.chrisdostert.shorturlsvc.dbadapter.{DbAdapter, DbAdapterConfig}
import com.chrisdostert.shorturlsvc.restapi.ReSTApi
import com.softwaremill.macwire._
import com.typesafe.config.{Config, ConfigFactory}
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
