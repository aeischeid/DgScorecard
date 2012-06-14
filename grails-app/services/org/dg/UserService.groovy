package org.dg

import org.apache.commons.lang.RandomStringUtils

class UserService {
    def springSecurityService

    AppUser getCurrentUser() {
        springSecurityService.currentUser
    }

    List<AppUser> search(String query) {
        List<AppUser> users = []
        if (query) {
            query.toLowerCase()

            query = "%${query}%"

            users = AppUser.createCriteria().list {
                or {
                    ilike('email', query)
                    ilike('username', query)
                }
            }
        }

        return users
    }

    AppUser createInactiveUser(String email) {
        AppUser user = new AppUser(
                email: email,
                enabled: false,
                password: RandomStringUtils.randomAlphanumeric(8),
                username: email
        )

        user.save()

        return user
    }
}
