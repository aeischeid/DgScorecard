package org.dg

class ScorecardController {
    static scaffold = true

    def index() { redirect(action: "list") }
}
