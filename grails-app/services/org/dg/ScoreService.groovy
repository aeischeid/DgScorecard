package org.dg

class ScoreService {
    def userService

    Score create(params) {
        Score score = new Score(params)

        if (params['playerName']) {
            score.player = User.findByUsername(params['playerName'])
        } else {
            score.player = userService.currentUser
        }

        score.save()

        return score
    }

    List<Score> findInProgressScores() {
        User currentUser = userService.currentUser

        Score.findAllByPlayerAndInProgress(currentUser, true)
    }

    List<Score> findScoresForCurrentUser() {
        User currentUser = userService.currentUser

        Score.findAllByPlayer(currentUser)
    }
}
