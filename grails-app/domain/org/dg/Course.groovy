package org.dg

class Course {
    String name
    String description
    Integer holes
    Integer par
    
    String streetAddress
    String city
    String state
    Integer zipCode
    
    static hasMany = [scores:Score]

    static constraints = {
        name()
        description()
        holes()
        par()
        
        streetAddress()
        city()
        state()
        zipCode()
    }
    
    public String toString() {
        "$name"
    }
}
