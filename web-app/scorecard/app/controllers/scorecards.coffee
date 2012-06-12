Spine      = require('spine')
Scorecard  = require('models/scorecard')
Player     = require('models/player')

class Scorecards extends Spine.Controller
	events:
		'click .holeScore'   :'enterHoleScore'
		'click button'       :'submitScore'
		'click #addPlayer'   :'addPlayer'
		'click .editPlayer'  :'editPlayer'
		'click .removePlayer':'removePlayer'
	
	constructor: ->
		super
		Player.fetch()
		@course = {holes:18, par:56}
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
		if @course.holes > 18
			@renderNine(3)
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
		for player in Player.all()
			player.startHole = startHole
			player.endHole = endHole
			$('tbody[data-nine="'+nine+'"]').append require('views/card/playerRow')(player)
	
	renderTally: ->
		@el.append require('views/card/tally')
		for player in Player.all()
			$('#tallies tbody').append require('views/card/tallyRow')(player)
			@calcScoreTally(player)
		
	enterHoleScore: (e)->
		cell = $(e.target)
		holeNum = cell.data('hole')
		#find the player this row belongs to
		playerId = cell.parent().data('player')
		player = Player.find(playerId)
		#@log("enter a score for hole number:" + cell.data('holenum'))
		holeScore = prompt("score", '3')
		cell.html holeScore
		player.scores[holeNum] = parseInt(holeScore, 10)
		player.save()
		@calcScoreTally(player)
		
	calcScoreTally: (player)->
		tally = 0
		for hole,holeScore of player.scores
			tally += holeScore
		#use jquery to select tally row, find the score input, and inject tally as value
		@$("tr[data-player='#{player.id}'] input[name='score']").val(tally)
		
	submitScore: (e)->
		@log 'time to get serious'
		for player in Player.all()
			scorecard = new Scorecard(playerName:player.name, score:3, courseId:1, notes:'not real...')
			console.log scorecard
	
	resetCourse: (courseObj)->
		@course = courseObj
		if confirm('abandon current game and unsaved scores?')
			@html ''
			@render()
		
	addPlayer: (e)->
		e.preventDefault()
		newPlayer = new Player(name:prompt('google id', '@gmail.com'), scores:{})
		newPlayer.save()
		@log Player.all()
		#need to trigger a re-render w/out losing all scores...
		
	editPlayer: (e)->
		e.preventDefault()
		@log $(e.target).parent().data('player')
		
	removePlayer: (e)->
		e.preventDefault()
		@log 'remove time'

module.exports = Scorecards

