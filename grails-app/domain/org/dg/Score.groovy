package org.dg
/**
 * Represents a game (or round) for a single player.
 * @param score number relative to par
 * @param throws total number of throws for the round, irregardless of par
 */
 

class Score implements Serializable {
    private static final long serialVersionUID = 3L

    Date date = new Date()
    Boolean inProgress = true
    String notes
    Integer score
    
    static belongsTo = [player:AppUser, course:Course]

    static constraints = {
        notes nullable:true
    }
    
    public String toString() {
        "${score}, ${player}"
    }
}
