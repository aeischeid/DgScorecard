package org.dg.remote

import grails.plugin.remotecontrol.RemoteControl
import org.dg.User

class UserRemoteControl {
    RemoteControl remote = new RemoteControl()

    User findUser(String username) {
        remote {
            User.findByUsername(username)
        }
    }
}
