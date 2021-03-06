import grails.converters.JSON
import grails.plugin.heroku.PostgresqlServiceInfo
import org.dg.Course
import org.dg.Score
import org.dg.AppUser

class BootStrap {

    def init = { servletContext ->
        boolean emptyDatabase = AppUser.count() == 0

        if (emptyDatabase) {
            AppUser user1 = new AppUser(username: "user1", password: "pass1", email: "user1@test.com", enabled: true).save()
            AppUser user2 = new AppUser(username: "user2", password: "pass1", email: "user2@test.com", enabled: true).save()

            Course course1 = new Course(name: "Course 1", holes: 18, par: 54).save(failOnError: true)

            Score user1Course1Score = new Score(score: 55, course: course1, player: user1).save(failOnError: true)
            Score user1Course1InProgressScore = new Score(score: 56, course: course1, player: user1, inProgress: true, notes: "In progress score").save(failOnError: true)
            Score user1Course1FinishedScore = new Score(score: 56, course: course1, player: user1, inProgress: false, notes: "Finished score").save(failOnError: true)

            Score user2Course1Score = new Score(score: 56, course: course1, player: user2, notes: "user2Course1Score").save(failOnError: true)
        }

        JSON.registerObjectMarshaller(AppUser) { AppUser user ->
            return [
                    email    : user.email,
                    id       : user.id,
                    username : user.username
            ]
        }

        String DATABASE_URL = System.getenv('DATABASE_URL')
        if (DATABASE_URL) {
            try {
                PostgresqlServiceInfo info = new PostgresqlServiceInfo()
                println "nPostgreSQL service ($DATABASE_URL): url='$info.url', " +
                        "user='$info.username', password='$info.password'n"
            }
            catch (e) {
                println "Error occurred parsing DATABASE_URL: $e.message"
            }
        }
    }
    def destroy = {
    }
}
