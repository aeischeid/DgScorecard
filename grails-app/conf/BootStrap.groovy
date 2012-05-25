import org.dg.User

class BootStrap {

    def init = { servletContext ->
        new User(username: "user1", password: "pass1", enabled: true).save()
    }
    def destroy = {
    }
}
