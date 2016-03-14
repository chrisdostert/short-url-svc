package com.urlable.shorturlsvc.dbadapter.usecases

import java.net.URL

import com.typesafe.config.ConfigFactory
import com.urlable.shorturlsvc.dbadapter.tdk.FutureConfig
import com.urlable.shorturlsvc.dbadapter.{CompositionRoot, DbAdapter, DbAdapterConfig}
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ArbitraryTypeReader._
import org.scalatest.FlatSpec

import scala.concurrent.Await
import scala.language.postfixOps

class CreateShortUrlUcIT
  extends FlatSpec {

  /** fields **/
  val dbAdapterConfig =
    ConfigFactory
      .load()
      .as[DbAdapterConfig](DbAdapterConfig.HOCON_PATH)

  val compositionRoot =
    new CompositionRoot(dbAdapterConfig)

  /** tests **/
  "execute" should "return a shortUrlView with the provided attributes and a non empty id" in {

    /** arrange **/
    val objectUnderTest =
      new DbAdapter(
        compositionRoot
      )

    val providedTarget = new URL("http://dummyurl.co")

    /** act **/
    val shortUrlView =
      Await.result(
        objectUnderTest
          .createShortUrl(providedTarget),
        FutureConfig.defaultTimeout
      )

    /** assert **/
    assert(shortUrlView.target == providedTarget)
    assert(shortUrlView.id.toString.nonEmpty)

  }

}
