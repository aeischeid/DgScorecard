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
