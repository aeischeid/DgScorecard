Spine = require('spine')

class Course extends Spine.Model
	@configure 'Course', 'name', 'lat', 'long', 'city', 'state', 'zip', 'holeCount'

module.exports = Course
