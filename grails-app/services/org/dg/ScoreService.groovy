package org.dg

class ScoreService {
    def springSecurityService

    Score create(params) {
        Score score = new Score(params)

        def currentUser = springSecurityService.currentUser

        score.player = currentUser

        score.save()

        return score
    }
}
