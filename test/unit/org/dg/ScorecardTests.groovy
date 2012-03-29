package org.dg

import grails.test.mixin.TestFor
import org.junit.Test

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Scorecard)
class ScorecardTests {

    @Test
    void whenMultipleHoleScoresShouldCalculateTotalScore() {
        Scorecard scorecard = new Scorecard()

        scorecard.addToHoleScores(holeNumber: 1, score: 2)
        scorecard.addToHoleScores(holeNumber: 2, score: 3)
        scorecard.addToHoleScores(holeNumber: 3, score: 3)

        assert scorecard.totalScore == 8
    }
}
