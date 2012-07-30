Spine = require('spine')
Ajax  = require('spine/lib/ajax')

class Course extends Spine.Model
	@configure 'Course', 'name', 'city', 'state', 'zip', 'holes', 'par'
	@extend Spine.Model.Ajax
	
	@url: '../api/course'
	
	#@filter: (query)->
		#@select (c) ->
			#c.zip.indexOf(query) is not -1

module.exports = Course
