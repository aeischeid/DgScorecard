Spine  = require('spine')
Scorecard  = require('models/scorecard')
Course = require('models/course')

class Scorecards extends Spine.Controller
	events:
		'click .holeScore' :'enterHoleScore'
	
	constructor: ->
		super
		@course = {holes:18, par:56}
		@players = [{name:'golfer1'},{name:'golfer2'},{name:'golfer3'}]
		@render()
		
	render: ->
		#@html require('views/card/card')(@course)
		# detrmine nines (as in how many 9's, since most courses will be played in holes by a factor of nine)
		#always render the first nine
		@renderNine(1)
		#second 9 is a maybe
		if @course.holes > 9
			@renderNine(2)
		
	renderNine: (n)->
		switch n
			when 1
				startHole = 1
				endHole = 9
			when 2
				startHole = 10
				endHole = 18
			when 3
				startHole = 19
				endHole = 27
		@el.append require('views/card/card')({nine:n, startHole:startHole, endHole:endHole})
		@renderRow(n, startHole, endHole)
		
	renderRow: (nine, startHole, endHole)->
		for player in @players
			player.startHole = startHole
			player.endHole = endHole
			$('tbody[data-nine="'+nine+'"]').append require('views/card/playerRow')(player)
		
	enterHoleScore: (e)->
		cell = $(e.target)
		@log("enter a score for hole number:" + cell.data('holenum'))
		cell.html prompt("score")
	
	@setCourse: (id)->
		@course = Course.find(id)
		@render()

module.exports = Scorecards