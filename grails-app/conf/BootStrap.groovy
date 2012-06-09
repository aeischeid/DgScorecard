import org.dg.Course
import org.dg.Score
import org.dg.User
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        User user1 = new User(username: "user1", password: "pass1", email: "user1@test.com", enabled: true).save()
        User user2 = new User(username: "user2", password: "pass1", email: "user2@test.com", enabled: true).save()

        Course course1 = new Course(name: "Course 1", holes: 18, par: 54).save(failOnError: true)

        Score user1Course1Score = new Score(score: 55, course: course1, player: user1).save(failOnError: true)
        Score user1Course1InProgressScore = new Score(score: 56, course: course1, player: user1, inProgress: true, notes: "In progress score").save(failOnError: true)
        Score user1Course1FinishedScore = new Score(score: 56, course: course1, player: user1, inProgress: false, notes: "Finished score").save(failOnError: true)

        JSON.registerObjectMarshaller(User) { User user ->
            return [
                    email    : user.email,
                    id       : user.id,
                    username : user.username
            ]
        }
    }
    def destroy = {
    }
}
