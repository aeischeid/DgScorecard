require('lib/setup')

Spine      = require('spine')
Course     = require('models/course')
Courses    = require('controllers/courses')
Scorecard  = require('models/scorecard')
Scorecards = require('controllers/scorecards')

class App extends Spine.Controller
	elements:
		'#courseInfo': 'courseSection'
		'#scorecard' : 'scoreTable'
	
	constructor: ->
		super
		console.log('hey app is here')
		# early on we can just get a list of all the courses... 
		courseRequest = Course.fetch()
		# probably should wait for this to return.
		#$.when(courseRequest).done ->
		#setTimeout( ->
		courses = new Courses({el:@courseSection})
		scorecard = new Scorecards({el:@scoreTable})
		#, 600)

module.exports = App
