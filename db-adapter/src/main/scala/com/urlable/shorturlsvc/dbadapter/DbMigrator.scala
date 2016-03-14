package com.urlable.shorturlsvc.dbadapter

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import org.flywaydb.core.Flyway

class DbMigrator(
  private val dbAdapterConfig: DbAdapterConfig
) {

  def migrate(): Unit = {
    val flyway = new Flyway()

    val initialTimeout = 10

    val mySqlDataSource = new MysqlDataSource()
    mySqlDataSource.setAutoReconnect(true)
    mySqlDataSource.setInitialTimeout(initialTimeout)
    mySqlDataSource.setLoginTimeout(dbAdapterConfig.loginTimeoutInSeconds)
    mySqlDataSource.setUser(dbAdapterConfig.username)
    mySqlDataSource.setPassword(dbAdapterConfig.password)
    mySqlDataSource.setPort(dbAdapterConfig.port)
    mySqlDataSource.setURL(dbAdapterConfig.url)

    flyway
      .setDataSource(mySqlDataSource)

    flyway.migrate()
  }

}
