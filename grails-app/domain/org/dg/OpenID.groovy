package org.dg

class OpenID {

    String url

    static belongsTo = [user: AppUser]

    static constraints = {
        url unique: true
    }
}
