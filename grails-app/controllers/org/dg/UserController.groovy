package org.dg

import grails.converters.JSON
import grails.plugins.springsecurity.Secured

@Secured('isAuthenticated()')
class UserController {
    def userService

    def info() {
        def currentUser = userService.currentUser

        if (currentUser) {
            render currentUser as JSON
        } else {
            response.status = 404
        }
    }

    def search(String query) {
        if (!query && params['term']) {
            query = params['term']
        }

        def users = userService.search(query)

        render users as JSON
    }
}
