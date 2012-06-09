package org.dg

import grails.plugins.springsecurity.Secured

@Secured('isAuthenticated()')
class IndexController {

    def index() {
        redirect(uri: "/scorecard/")
    }
}
