package org.dg

/**
 * Represents a disc golf course
 * <p>
 * Courses may have multiple factors which make them more complicated
 * like various arrangement for playing or movable tees etc.
 * We aren't going to try to account for all of that, just the simpler
 * attributes like number of holes and a general par. the scores entered
 * are arbitrary anyway. players can track their own performance and any others
 * that adhere to the same scoring convention, but finding a way to rank and 
 * validate top scores in an absolute manner would require a much more precise 
 * and complex model 
 */

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
