package org.dg

class Role implements Serializable {
    private static final long serialVersionUID = 1L

    String authority

    static mapping = {
        cache true
    }

    static constraints = {
        authority blank: false, unique: true
    }
}
