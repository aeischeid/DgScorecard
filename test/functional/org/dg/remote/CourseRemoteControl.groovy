package org.dg.remote

import grails.plugin.remotecontrol.RemoteControl
import org.dg.Course

class CourseRemoteControl {
    RemoteControl remote = new RemoteControl()

    List<Course> list() {
        remote {
            Course.list()
        }
    }

    Course findByName(String name) {
        remote {
            Course.findByName(name)
        }
    }
}
