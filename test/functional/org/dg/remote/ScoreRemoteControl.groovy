package org.dg.remote

import grails.plugin.remotecontrol.RemoteControl
import org.dg.Score
import org.dg.User

class ScoreRemoteControl {
    RemoteControl remote = new RemoteControl()

    List<Score> findScoresForPlayer(String username) {
        remote {
            User player = User.findByUsername(username)

            if (player) {
                Score.findAllByPlayer(player)
            } else {
                []
            }
        }
    }
}
