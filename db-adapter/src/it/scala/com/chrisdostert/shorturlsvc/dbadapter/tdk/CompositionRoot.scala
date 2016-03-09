package com.chrisdostert.shorturlsvc.dbadapter.tdk

import com.chrisdostert.shorturlsvc.dbadapter.DbAdapterConfig
import com.typesafe.config.ConfigFactory
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ArbitraryTypeReader._

trait CompositionRoot {


  private lazy val dbAdapterConfig =
    ConfigFactory
      .load()
      .as[DbAdapterConfig](DbAdapterConfig.HOCON_PATH)

  lazy val compositionRoot =
    new com.chrisdostert.shorturlsvc.dbadapter.CompositionRoot(dbAdapterConfig)

}

object CompositionRoot extends CompositionRoot
