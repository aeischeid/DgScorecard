require('lib/setup')

Spine      = require('spine')
Course     = require('models/course')
Courses    = require('controllers/courses')
Scorecard  = require('models/scorecard')
Scorecards = require('controllers/scorecards')

class App extends Spine.Controller
	events:
		'change #courseSel':'changeCourse'
		'click .holeScore' :'enterHoleScore'
	
	elements:
		'#courseInfo': 'courseSection'
		'#scorecard' : 'scoreTable'
	
	constructor: ->
		super
		console.log('hey app is here')
		# early on we can just get a list of all the courses... 
		Course.fetch()
		# probably should wait for this to return.
		courses = new Courses({el:@courseSection})
		scorecard = new Scorecards({el:@scoreTable})

module.exports = App
