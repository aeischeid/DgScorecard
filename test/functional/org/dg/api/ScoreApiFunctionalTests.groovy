package org.dg.api

import grails.converters.JSON
import org.dg.Course
import org.dg.remote.CourseRemoteControl
import org.dg.remote.ScoreRemoteControl

class ScoreApiFunctionalTests extends JsonRestApiFunctionalTestCase {
    CourseRemoteControl courseRemoteControl = new CourseRemoteControl()
    ScoreRemoteControl scoreRemoteControl = new ScoreRemoteControl()

    void testShouldGetScoresForCurrentUser() {
        def userScores = scoreRemoteControl.findScoresForPlayer('user1')

        doJsonGet("/api/score")

        assertStatus(200)

        def json = parsedJsonArray

        assert json.size() == userScores.size()

        def jsonIds = json.collect { it['id'].toString() }

        userScores.each {
            assert jsonIds.contains(it.id.toString())
        }
    }

    void testShouldCreateScoreForCurrentUser() {
        Course course = courseRemoteControl.findByName("Course 1")

        Integer scoreVal = 54
        String scoreNotes = "My new score"

        String jsonString = new JSON(
                "course.id": course.id,
                "notes": scoreNotes,
                "score": scoreVal
        ).toString()

        doJsonPost("/api/score", jsonString)

        assertStatus(201)

        def userScores = scoreRemoteControl.findScoresForPlayer('user1')

        def newUserScore = userScores.find { it.notes == scoreNotes }
        assert newUserScore

        assert newUserScore.score == scoreVal
    }

    void testShouldCreateScoreForAnotherUser() {
        Course course = courseRemoteControl.findByName("Course 1")

        Integer scoreVal = 52
        String scoreNotes = "User2 new score"

        String jsonString = new JSON(
                "course.id": course.id,
                "notes": scoreNotes,
                "playerName": 'user2',
                "score": scoreVal
        ).toString()

        doJsonPost("/api/score", jsonString)

        assertStatus(201)

        def userScores = scoreRemoteControl.findScoresForPlayer('user2')

        def newUserScore = userScores.find { it.notes == scoreNotes }
        assert newUserScore

        assert newUserScore.score == scoreVal
    }
}
