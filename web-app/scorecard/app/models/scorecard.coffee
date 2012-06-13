Spine = require('spine')

class Scorecard extends Spine.Model
	@configure 'Scorecard', 'score', 'notes', 'course.id', 'playerEmail', 'inProgress'
	@extend Spine.Model.Ajax
	
	@url: '../api/score'

module.exports = Scorecard
