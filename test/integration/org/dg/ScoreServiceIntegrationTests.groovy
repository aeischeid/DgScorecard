package org.dg

import org.junit.Before
import org.junit.Test

class ScoreServiceIntegrationTests extends DgScoreIntegrationTestCase {
    ScoreService scoreService

    Course course

    Score inProgressScore
    Score finishedScore
    Score user2Score

    @Before
    void setUp() {
        login('user1')

        course = Course.list()[0]

        inProgressScore = Score.findByNotes("In progress score")
        finishedScore = Score.findByNotes("Finished score")
        user2Score = Score.findByNotes("user2Course1Score")
    }

    @Test
    void shouldCreateNewScore() {
        def params = [score: 52, notes: "New Score notes", 'course.id': course.id]

        def newScore = scoreService.create(params)

        assert !newScore.errors?.allErrors

        assert newScore['score'] == params['score']
        assert newScore['notes'] == params['notes']
    }

    @Test
    void whenScoreForOtherExistingUserShouldCreateScore() {
        User user2 = User.findByUsername('user2')

        def params = [score: 52, notes: "New score for user 2", 'course.id': course.id, playerEmail: user2.email]

        def newScore = scoreService.create(params)
        assert !newScore.errors?.allErrors

        assert newScore.player == user2
    }

    @Test
    void whenScoreForOtherUserThatDoesNotExistYetShouldCreateScoreAndUser() {
        String otherUserEmail = "otheruser@dg.org"

        def params = [score: 52, notes: "New score for other user", 'course.id': course.id, playerEmail: otherUserEmail]

        def newScore = scoreService.create(params)
        assert !newScore.errors?.allErrors

        User newUser = User.findByEmail(otherUserEmail)
        assert newUser
        assert !newUser.enabled

        assert newScore.player == newUser
    }

    @Test
    void shouldFindInProgressScores() {
        def inProgressScores = scoreService.findInProgressScores()

        assert inProgressScores.contains(inProgressScore)
        assert !inProgressScores.contains(finishedScore)
        assert !inProgressScores.contains(user2Score)
    }

    @Test
    void testShouldFindAllScores() {
        def scores = scoreService.findScoresForCurrentUser()

        assert scores.contains(inProgressScore)
        assert scores.contains(finishedScore)
        assert !scores.contains(user2Score)
    }
}
