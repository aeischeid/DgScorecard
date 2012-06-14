package org.dg.remote

import grails.plugin.remotecontrol.RemoteControl
import org.dg.Score
import org.dg.AppUser

class ScoreRemoteControl {
    RemoteControl remote = new RemoteControl()

    List<Score> findScoresForPlayer(String username) {
        remote {
            AppUser player = AppUser.findByUsername(username)

            if (player) {
                Score.findAllByPlayer(player)
            } else {
                []
            }
        }
    }

    Score findScoreForPlayer(String username, String notes) {
        remote {
            AppUser player = AppUser.findByUsername(username)

            if (player) {
                Score.findByPlayerAndNotes(player, notes)
            } else {
                null
            }
        }
    }
}
