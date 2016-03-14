package com.urlable.shorturlsvc.dbadapter.tdk

import com.typesafe.config.ConfigFactory
import com.urlable.shorturlsvc.dbadapter.DbAdapterConfig
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ArbitraryTypeReader._

trait CompositionRoot {


  private lazy val dbAdapterConfig =
    ConfigFactory
      .load()
      .as[DbAdapterConfig](DbAdapterConfig.HOCON_PATH)

  lazy val compositionRoot =
    new com.urlable.shorturlsvc.dbadapter.CompositionRoot(dbAdapterConfig)

}

object CompositionRoot extends CompositionRoot
