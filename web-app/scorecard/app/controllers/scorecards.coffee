Spine = require('spine')

class Scorecards extends Spine.Controller
	events:
		'click .holeScore' :'enterHoleScore'
	
	constructor: ->
		super
		@render()
		
	render: ->
		@html require('views/scorecard')
		
	enterHoleScore: ->

module.exports = Scorecards
