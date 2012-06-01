package org.dg
/**
 * Represents a game (or round) for a single player.
 * @param score number relative to par
 * @param throws total number of throws for the round, irregardless of par
 */
 

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
