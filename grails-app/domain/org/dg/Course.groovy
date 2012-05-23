package org.dg

class Course {
	String name
	String description
	
	Integer numberOfHoles
	
	String city
	String state
	String zipCode
	
	static hasMany = [configurations:CourseConfiguration]

	static constraints = {
	}
}
