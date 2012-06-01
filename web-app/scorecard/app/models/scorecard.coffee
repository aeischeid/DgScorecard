Spine = require('spine')

class Scorecard extends Spine.Model
	@configure 'Scorecard'
	@extend Spine.Model.Ajax
	@url: '../api/score'
	
module.exports = Scorecard
