//import org.springframework.security.access.AccessDeniedException

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
			// apply constraints here
			}
		}
		"/events/$className/$id"{
			controller = "events"
			action = "show"
			constraints {
				// apply constraints here
			}
		}
		name api0: "/api/$controller/$id"(parseRequest:true){
			action = [GET: "show", PUT: "update", DELETE: "delete"]
			constraints {
				id(matches:/\d+/)
			}
		}
		
		name api1: "/api/$controller"(parseRequest:true){
			action = [GET: "list", POST: "save"]
		}

		name api2: "/api/$controller/$action"(parseRequest:true)
		
		name api3: "/api/$controller/$action/$id"(parseRequest:true)

		// you could set up deployments to have servers configured to serve spine 
		// app seperate from grails app. or in this case the spine app is within
		// the web-app dir of the grails app.
		"/scorecard/"(uri:"/scorecard/public/index.html")
		
		"/"(view:"/index")

		"403"(controller: "error", action: "error403")
		"404"(controller: "error", action: "error404")
		//"409"(controller: "error", action: "error409")
		"500"(controller: "error", action: "error500")
		//"500"(controller: "error", action: "error403", exception: AccessDeniedException)
		//"500"(controller: "error", action: "error404", exception: NotFoundException)
	}
}
