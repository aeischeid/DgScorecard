package org.dg

import grails.converters.JSON

class UserController {
    def userService

    def info() {
        def currentUser = userService.currentUser

        if (currentUser) {
            def userInfoMap = [
                    'email': currentUser.email,
                    'username': currentUser.username
            ]

            render userInfoMap as JSON
        } else {
            response.status = 404
        }
    }
}
