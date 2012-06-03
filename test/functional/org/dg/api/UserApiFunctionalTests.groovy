package org.dg.api

import org.dg.User
import org.dg.remote.UserRemoteControl

class UserApiFunctionalTests extends JsonRestApiFunctionalTestCase {
    UserRemoteControl userRemoteControl = new UserRemoteControl()

    void testShouldGetUserInfo() {
        User user1 = userRemoteControl.findUser('user1')

        doJsonGet("/api/user/info")

        assertStatus(200)

        def json = parsedJsonSingleElement

        assert json['email'] == user1.email
        assert json['username'] == user1.username
    }
}
