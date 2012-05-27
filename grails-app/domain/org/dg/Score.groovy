package org.dg

class Score implements Serializable {
    private static final long serialVersionUID = 2L

    Integer score
    String notes
    Date date = new Date()
    
    static belongsTo = [player:User, course:Course]

    static constraints = {
        notes nullable:true
    }
}
