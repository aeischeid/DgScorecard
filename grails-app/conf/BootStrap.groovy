import org.dg.Course
import org.dg.Score
import org.dg.User

class BootStrap {

    def init = { servletContext ->
        User user1 = new User(username: "user1", password: "pass1", enabled: true).save()

        Course course1 = new Course(name: "Course 1", holes: 18, par: 54).save(failOnError: true)

        Score user1Course1Score = new Score(score: 55, course: course1, player: user1).save(failOnError: true)
    }
    def destroy = {
    }
}
