<%=packageName ? "package ${packageName}\n\n" : ''%>import org.springframework.dao.DataIntegrityViolationException
import grails.converters.XML
import grails.converters.JSON

class ${className}Controller {

	static allowedMethods = [list:'GET',
							show:'GET',
							edit:['GET', 'POST'],
							save:'POST',
							update:['POST','PUT'],
						    delete:['POST','DELETE']]

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		def list = ${className}.list(params)
		def listObject = [${propertyName}List: list, ${propertyName}Total: ${className}.count()]
		withFormat {
			html listObject
			json {
				if (list) render list as JSON
				else {
					response.status = 204
					render ''
				}
			}
			xml { render listObject as XML }
		}
	}

	def create() {
		[${propertyName}: new ${className}(params)]
	}

	def save() {
		def ${propertyName} = new ${className}(params)
		if (!${propertyName}.save(flush: true)) {
			withFormat {
				html {render(view: "create", model: [${propertyName}: ${propertyName}])}
				json {
					response.status = 400
					render ${propertyName}.errors as JSON
				}
				xml {
					response.status = 400
					render ${propertyName}.errors as XML
				}
			}
			return
		}
		withFormat {
			html {
				flash.message = message(code: 'default.created.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), ${propertyName}.id])
				redirect(action: "show", id: ${propertyName}.id)
			}
			json {
				response.status = 201
				render ${propertyName} as JSON
			}
			xml {
				response.status = 201
				render ${propertyName}.id
			}
		}
	}

	def show() {
		def ${propertyName} = ${className}.get(params.id)
		if (!${propertyName}) {
			withFormat {
				html {
					flash.message = message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])
					redirect(action: "list")
				}
				json { response.sendError(404) }
				xml { response.sendError(404) }
			}
			return
		}
		withFormat {
			html {[${propertyName}: ${propertyName}]}
			json { render ${propertyName} as JSON }
			xml { render ${propertyName} as XML }
		}
	}

	def edit() {
		def ${propertyName} = ${className}.get(params.id)
		if (!${propertyName}) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])
			redirect(action: "list")
			return
		}
		[${propertyName}: ${propertyName}]
	}

	def update() {
		def ${propertyName} = ${className}.get(params.id)
		if (!${propertyName}) {
			withFormat {
				html {
					flash.message = message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])
					redirect(action:"list")
				}
				json { response.sendError(404) }
				xml { response.sendError(404) }
			}
			return
		}

		if (params.version) {
			def version = params.version.toLong()
			if (${propertyName}.version > version) {<% def lowerCaseName = grails.util.GrailsNameUtils.getPropertyName(className) %>
				${propertyName}.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: '${domainClass.propertyName}.label', default: '${className}')] as Object[],
						  "Another appUser has updated this ${className} while you were editing")
				withFormat {
					html {render(view: "edit", model: [${propertyName}: ${propertyName}])}
					json { response.sendError(409) }
					xml { response.sendError(409) }
				}
				return
			}
		}

		${propertyName}.properties = params

		if (!${propertyName}.save(flush: true)) {
			withFormat {
				html {render(view: "edit", model: [${propertyName}: ${propertyName}])}
				json {
					response.status = 400
					render ${propertyName}.errors as JSON
				}
				xml {
					response.status = 400
					render ${propertyName}.errors as XML
				}
			}
			return
		}
		withFormat {
			html {
				flash.message = message(code: 'default.updated.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), ${propertyName}.id])
				redirect(action: "show", id: ${propertyName}.id)
			}
			json {
				render ${propertyName} as JSON
			}
			xml {
				render ${propertyName} as XML
			}
		}
	}

	def delete() {
		def ${propertyName} = ${className}.get(params.id)
		if (!${propertyName}) {
			withFormat {
				html {
					flash.message = message(code: 'default.not.found.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])
					redirect(action: "list")
				}
				json { response.sendError(404) }
				xml { response.sendError(404) }
			}
			return
		}
		try {
			${propertyName}.delete(flush: true)
			withFormat {
				html {
					flash.message = message(code: 'default.deleted.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])
					redirect(action: "list")
				}
				json {
					response.status = 204
					render ''
				}
				xml {
					response.status = 204
					render ''
				}
			}
		}
		catch (DataIntegrityViolationException e) {
			withFormat {
				html {
					flash.message = message(code: 'default.not.deleted.message', args: [message(code: '${domainClass.propertyName}.label', default: '${className}'), params.id])
					redirect(action: "show", id: params.id)
				}
				json { response.sendError(500) }
				xml { response.sendError(500) }
			}
		}
	}
}
