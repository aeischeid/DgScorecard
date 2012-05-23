package org.dg

class CourseConfiguration {
	String name
	String description
	
	static belongsTo = [course:Course]
	
	static hasMany = [holes:Hole]
	
	static constraints = {
	}
}
