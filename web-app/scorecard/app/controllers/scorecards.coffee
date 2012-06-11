Spine  = require('spine')
Scorecard  = require('models/scorecard')

class Scorecards extends Spine.Controller
	events:
		'click .holeScore'   :'enterHoleScore'
		'click button'       :'submitScore'
		'click #addPlayer'   :'addPlayer'
		'click .editPlayer'  :'editPlayer'
		'click .removePlayer':'removePlayer'
	
	constructor: ->
		super
		@course = {holes:18, par:56}
		@players = [{name:'golfer1'},{name:'golfer2'},{name:'golfer3'}]
		Spine.bind 'changeCourse', (courseObj) =>
			@resetCourse(courseObj)
		@render()
		
	render: ->
		#@html require('views/card/card')(@course)
		@log @course
		# detrmine nines (as in how many 9's, since most courses will be played in holes by a factor of nine)
		#always render the first nine
		@renderNine(1)
		#second 9 is a maybe
		if @course.holes > 9
			@renderNine(2)
		@renderTally()
		
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
	
	renderTally: ->
		@el.append require('views/card/tally')
		for player in @players
			$('#tallies tbody').append require('views/card/tallyRow')(player)
		
	enterHoleScore: (e)->
		cell = $(e.target)
		#find the player row this cell belongs to
		@log cell.parent().data('player')
		#@log("enter a score for hole number:" + cell.data('holenum'))
		holeScore = prompt("score", '3')
		cell.html holeScore
		#add hole score to the tally for given player
		
	submitScore: (e)->
		@log 'time to get serious'
	
	resetCourse: (courseObj)->
		@course = courseObj
		if confirm('abandon current game and unsaved scores?')
			@html ''
			@render()
		
	addPlayer: (e)->
		e.preventDefault()
		@players.push({name:prompt('google id', '@gmail.com')})
		
	editPlayer: (e)->
		e.preventDefault()
		@log $(e.target).parent().data('player')
		
	removePlayer: (e)->
		e.preventDefault()
		@log 'remove time'

module.exports = Scorecards

