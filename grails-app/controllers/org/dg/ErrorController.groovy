package org.dg

class ErrorController {

	def error403 = {
		withFormat {
			html {
				render(view: "error403")
			}
			json {
				response.status = 403
				render ''
			}
		}
	}

	def error404 = {
		withFormat {
			html {
				render(view: "error404")
			}
			json {
				response.status = 404
				render ''
			}
		}
	}
	
	def error409 = {
		withFormat {
			json {
				response.status = 409
				render ''
			}
		}
	}

	def error500 = { 
		withFormat {
			html {
				render(view: "error")
			}
			json {
				response.status = 500
				render ''
			}
		}
	}
}
