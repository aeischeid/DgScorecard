package org.dg

class Hole {
	static belongsTo = [courseConfiguration:CourseConfiguration]
	
	static hasMany = [holeScores:HoleScore]
	
	Integer holeNumber
	Integer par
	Integer distance
	String description

	static constraints = {
	}
}
