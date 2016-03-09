package com.chrisdostert.shorturlsvc.server

object Server extends App {

  private val compositionRoot =
    new CompositionRoot()

  compositionRoot
    .restApi

}
