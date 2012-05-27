package org.dg.api

import org.dg.remote.ScoreRemoteControl

class ScoreApiFunctionalTests extends JsonRestApiFunctionalTestCase {
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
}
