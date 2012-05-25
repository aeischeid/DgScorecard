package org.dg

class Score implements Serializable {
    private static final long serialVersionUID = 1L

    Integer score
    String notes
    Date date
    
    static belongsTo = [player:User, course:Course]

    static constraints = {
        notes nullable:true
    }
}
