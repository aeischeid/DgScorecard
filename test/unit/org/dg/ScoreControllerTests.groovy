package org.dg

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.gmock.WithGMock
import org.junit.Before
import org.junit.Test

@TestFor(ScoreController)
@WithGMock
@Mock(Score)
class ScoreControllerTests {
    ScoreService scoreService

    @Before
    void setUp() {
        scoreService = mock(ScoreService)
        controller.scoreService = scoreService
    }

    @Test
    void shouldListScoresForCurrentUser() {
        Score score = new Score(score: 52, notes: "Score notes")

        scoreService.findScoresForCurrentUser().returns([score])

        response.format = 'json'

        play {
            controller.list()
        }

        assert response.status == 200

        assert response.json.size() == 1

        def json = response.json[0]

        assert json['score'] == score.score
        assert json['notes'] == score.notes
    }

    @Test
    void whenSavingScoreSucceedsShouldRenderScore() {
        Score newScore = new Score(score: 52, notes: "New score notes")

        scoreService.create(controller.params).returns(newScore)

        response.format = 'json'

        play {
            controller.save()
        }

        assert response.status == 201

        def json = response.json

        assert json['score'] == newScore.score
        assert json['notes'] == newScore.notes
    }

    @Test
    void whenSavingScoreFailsShouldReturnError() {
        Score invalidScore = new Score()
        assert !invalidScore.validate()

        scoreService.create(controller.params).returns(invalidScore)

        response.format = 'json'

        play {
            controller.save()
        }

        assert response.status == 400
    }

    @Test
    void shouldFindInProgressScores() {
        def inProgressScores = [new Score(), new Score()]

        scoreService.findInProgressScores().returns(inProgressScores)

        play {
            controller.inProgress()
        }

        assert response.status == 200

        assert response.json.size() == inProgressScores.size()
    }
}
