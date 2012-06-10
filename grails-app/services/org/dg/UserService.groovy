package org.dg

import org.apache.commons.lang.RandomStringUtils

class UserService {
    def springSecurityService

    User getCurrentUser() {
        springSecurityService.currentUser
    }

    List<User> search(String query) {
        List<User> users = []
        if (query) {
            query.toLowerCase()

            query = "%${query}%"

            users = User.createCriteria().list {
                or {
                    ilike('email', query)
                    ilike('username', query)
                }
            }
        }

        return users
    }

    User createInactiveUser(String email) {
        User user = new User(
                email: email,
                enabled: false,
                password: RandomStringUtils.randomAlphanumeric(8),
                username: email
        )

        user.save()

        return user
    }
}
