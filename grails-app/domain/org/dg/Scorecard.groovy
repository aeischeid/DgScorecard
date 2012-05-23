package org.dg

class Scorecard {
		CourseConfiguration courseConfiguration

		static hasMany = [players:User, holeScores: HoleScore]

		static constraints = {
		}

		static transients = ['totalScore']
		
		Integer getTotalScore() {
			Integer totalScore = 0

			holeScores.each { holeScore ->
				totalScore += holeScore.score
			}

			return totalScore
		}
}
