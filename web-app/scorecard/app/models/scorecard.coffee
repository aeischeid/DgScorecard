Spine = require('spine')

class Scorecard extends Spine.Model
	@configure 'Scorecard', 'score', 'notes', 'courseId', 'playerName'
	@extend Spine.Model.Ajax
	
	@url: '../api/score'

module.exports = Scorecard
