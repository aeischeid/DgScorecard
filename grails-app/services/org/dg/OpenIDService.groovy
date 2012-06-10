package org.dg

import org.springframework.security.openid.OpenIDAttribute
import org.codehaus.groovy.grails.plugins.springsecurity.openid.OpenIdAuthenticationFailureHandler as OIAFH

class OpenIDService {
    def getOpenID(session) {
        return session[OIAFH.LAST_OPENID_USERNAME]
    }

    String getEmailAddress(session) {
        return getOpenIdAttributeValue(session, "email")
    }

    private String getOpenIdAttributeValue(session, String attributeName) {
        List<OpenIDAttribute> attributes =  session[OIAFH.LAST_OPENID_ATTRIBUTES]

        for (attribute in attributes) {
            if (attribute.name.equals(attributeName)) {
                return attribute.values.get(0)
            }
        }
    }
}
