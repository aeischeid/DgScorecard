package org.dg

import org.junit.Before
import org.junit.Test

class UserServiceIntegrationTests extends DgScoreIntegrationTestCase {
    UserService userService

    User user1

    @Before
    void setUp() {
        user1 = User.findByUsername('user1')
    }

    @Test
    void whenSearchingByEmailShouldFindUser() {
        def users = userService.search(user1.email)

        assert users == [user1]
    }

    @Test
    void whenSearchingByUsernameShouldFindUser() {
        def users = userService.search(user1.username)

        assert users == [user1]
    }

    @Test
    void whenSearchingByInvalidUsernameShouldNotFindAnyUsers() {
        def users = userService.search('blah')

        assert users.size() == 0
    }
}
