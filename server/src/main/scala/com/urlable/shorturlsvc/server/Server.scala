package com.urlable.shorturlsvc.server

object Server extends App {

  private val compositionRoot =
    new CompositionRoot()

  compositionRoot
    .restApi

}
