Spine = require('spine')
Ajax  = require('spine/lib/ajax')

class Scorecard extends Spine.Model
	@configure 'Scorecard', 'score', 'notes', 'course.id', 'playerEmail', 'inProgress'
	@extend Spine.Model.Ajax
	
	@url: '../api/score'

module.exports = Scorecard
