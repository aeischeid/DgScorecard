package org.dg.api

import grails.converters.JSON
import org.dg.Course
import org.dg.remote.CourseRemoteControl

class CourseApiFunctionalTests extends JsonRestApiFunctionalTestCase {
    CourseRemoteControl courseRemoteControl = new CourseRemoteControl()

    void testShouldCreateNewCourse() {
        final String name = "New Ccourse"
        final String description = "Course Description"
        final Integer holes = 18
        final Integer par = 54

        final String streetAddress = "123 Main Street"
        final String city = "Ames"
        final String state = "IA"
        final String zipCode = "50013"

        String jsonString = new JSON(
                name: name,
                description: description,
                holes: holes,
                par: par,

                streetAddress: streetAddress,
                city: city,
                state: state,
                zipCode: zipCode
        ).toString()

        doJsonPost("/api/course", jsonString)

        assertStatus(201)

        def json = parsedJsonSingleElement

        assert json.name == name
        assert json.description == description
        assert json.holes == holes
        assert json.par == par

        assert json.streetAddress == streetAddress
        assert json.city == city
        assert json.state == state
        assert json.zipCode == zipCode

        Course newCourse = courseRemoteControl.findByName(name)
        assert newCourse

        assert newCourse.description == description
        assert newCourse.holes == holes
        assert newCourse.par == par

        assert newCourse.streetAddress == streetAddress
        assert newCourse.city == city
        assert newCourse.state == state
        assert newCourse.zipCode == zipCode
    }
}
