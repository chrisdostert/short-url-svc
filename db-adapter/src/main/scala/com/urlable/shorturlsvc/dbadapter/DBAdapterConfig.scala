package com.urlable.shorturlsvc.dbadapter

case class DbAdapterConfig(
  username: String,
  password: String,
  schema: String,
  hostname: String,
  port: Int,
  loginTimeoutInSeconds: Int
) {

  val url: String = s"jdbc:mysql://$hostname:$port/$schema"

}

object DbAdapterConfig {

  val HOCON_PATH = "db-adapter"

}
