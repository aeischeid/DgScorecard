package org.dg

class Score {
    Integer score
    String notes
    
    static belongsTo = [player:User, course:Course]

    static constraints = {
        notes nullable:true
    }
}
