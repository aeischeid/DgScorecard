package org.dg

abstract class DgScoreIntegrationTestCase {
    def springSecurityService

    void login(String username) {
        springSecurityService.reauthenticate(username, null)
    }
}
