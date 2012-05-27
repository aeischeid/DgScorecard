package org.dg

class Course implements Serializable {
    private static final long serialVersionUID = 1L

    String name
    String description
    Integer holes
    Integer par
    
    String streetAddress
    String city
    String state
    String zipCode
    
    static hasMany = [scores:Score]

    static constraints = {
        name()
        description(nullable: true)
        holes()
        par()
        
        streetAddress(nullable: true)
        city(nullable: true)
        state(nullable: true)
        zipCode(nullable: true)
    }
    
    public String toString() {
        "$name"
    }
}
