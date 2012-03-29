package org.dg

class CourseController {
    static scaffold = true

    def index() { redirect(action: "list") }
}
