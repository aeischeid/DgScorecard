package org.dg

class ScoreService {
    def userService

    Score create(params) {
        Score score = new Score(params)

        String otherPlayerEmail = params['playerEmail']

        if (otherPlayerEmail) {
            User otherPlayer = User.findByEmail(otherPlayerEmail)

            if (!otherPlayer) {
                otherPlayer = userService.createInactiveUser(otherPlayerEmail)
            }

            score.player = otherPlayer
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
