package org.dg

class ScoreService {
    def springSecurityService

    Score create(params) {
        Score score = new Score(params)

        if (params['playerName']) {
            score.player = User.findByUsername(params['playerName'])
        } else {
            score.player = springSecurityService.currentUser
        }

        score.save()

        return score
    }
}
