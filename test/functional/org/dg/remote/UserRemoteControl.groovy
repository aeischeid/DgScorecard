package org.dg.remote

import grails.plugin.remotecontrol.RemoteControl
import org.dg.AppUser

class UserRemoteControl {
    RemoteControl remote = new RemoteControl()

    AppUser findUser(String username) {
        remote {
            AppUser.findByUsername(username)
        }
    }
}
