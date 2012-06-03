package org.dg

class UserService {
    def springSecurityService

    User getCurrentUser() {
        springSecurityService.currentUser
    }
}
