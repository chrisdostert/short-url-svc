package com.urlable.shorturlsvc.server

import com.urlable.shorturlsvc.core.tdk.BaseFunSpecTest

class ServerIT extends BaseFunSpecTest {

  describe("starting in current thread") {

    it("should not throw") {

      /** arrange/act/assert **/

      Server.main(Array())

    }

  }

}
