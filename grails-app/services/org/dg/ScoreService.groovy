package org.dg

class ScoreService {
    def userService

    Score create(params) {
        Score score = new Score(params)

        String otherPlayerEmail = params['playerEmail']

        if (otherPlayerEmail) {
            AppUser otherPlayer = AppUser.findByEmail(otherPlayerEmail)

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
        AppUser currentUser = userService.currentUser

        Score.findAllByPlayerAndInProgress(currentUser, true)
    }

    List<Score> findScoresForCurrentUser() {
        AppUser currentUser = userService.currentUser

        Score.findAllByPlayer(currentUser)
    }
}
