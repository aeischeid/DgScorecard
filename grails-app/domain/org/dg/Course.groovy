package org.dg

class Course {
    String name
    String description
    Integer holes
    Integer par
    
    String city
    String state
    Integer zipCode
    
    static hasMany = [scores:Score]

    static constraints = {
    }
}
