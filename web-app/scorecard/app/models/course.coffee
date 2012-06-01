Spine = require('spine')

class Course extends Spine.Model
	@configure 'Course', 'name', 'city', 'state', 'zip', 'holes', 'par'
	@extend Spine.Model.Ajax
	
	@url: '../api/course'
	
	#@filter: (zip)->
		

module.exports = Course
