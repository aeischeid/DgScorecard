package org.dg

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
}
