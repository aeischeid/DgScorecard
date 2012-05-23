package org.dg

class Score {
    Integer score
    String notes
    Date date
    
    static belongsTo = [player:User, course:Course]

    static constraints = {
        notes nullable:true
    }
}
