package org.dg.api

import org.dg.AppUser
import org.dg.remote.UserRemoteControl
import org.dg.AppUser

class UserApiFunctionalTests extends JsonRestApiFunctionalTestCase {
    UserRemoteControl userRemoteControl = new UserRemoteControl()

    void testShouldGetUserInfo() {
        AppUser user1 = userRemoteControl.findUser('user1')

        doJsonGet("/api/user/info")

        assertStatus(200)

        def json = parsedJsonSingleElement

        assert json['email'] == user1.email
        assert json['id'] == user1.id
        assert json['username'] == user1.username
    }

    void testShouldSearchForUserByUsername() {
        AppUser user = userRemoteControl.findUser('user1')

        doJsonGet("/api/user/search?query=${user.username}")

        assertStatus(200)

        def userJson = parsedJsonArray.find {it['id'] == user.id}
        assert userJson

        assert userJson['username'] == user.username
    }
}
