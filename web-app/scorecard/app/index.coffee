require('lib/setup')

Spine      = require('spine')
Course     = require('models/course')
Courses    = require('controllers/courses')

class App extends Spine.Controller
	elements:
		'#courseInfo': 'courseSection'
		'#scorecard' : 'scoreTable'
	
	constructor: ->
		super
		console.log('app is alive i guess!?')
		# early on we can just get a list of all the courses... 
		courseRequest = Course.fetch()
		# probably should wait for this to return.
		#$.when(courseRequest).done ->
		#setTimeout( ->
		courses = new Courses({el:@courseSection})
		
		#, 600)

module.exports = App
