package org.dg

class Score implements Serializable {
    private static final long serialVersionUID = 3L

    Date date = new Date()
    Boolean inProgress = true
    String notes
    Integer score
    
    static belongsTo = [player:User, course:Course]

    static constraints = {
        notes nullable:true
    }
}
