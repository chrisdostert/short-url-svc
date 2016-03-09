package com.chrisdostert.shorturlsvc.dbadapter.tdk

import scala.concurrent.duration._

trait FutureConfig {

  final val defaultTimeout = 120 seconds

}

object FutureConfig extends FutureConfig
