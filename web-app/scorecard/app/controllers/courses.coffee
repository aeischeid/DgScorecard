Spine  = require('spine')
Course = require('models/course')
Scorecards = require('controllers/scorecards')

class Courses extends Spine.Controller
	@item = {}
	events:
		'change #courseSel':'changeCourse'
	
	elements:
		'#courseSel'    :'courseSel'
		'#courseFilter' :'filter'
	
	constructor: ->
		super
		@html require('views/course/selector')
		Course.bind 'refresh', @list
		@scorecard = new Scorecards({el:$("#scorecard")})
		
	list: (filter)->
		#if filter
		#else
		courses = Course.all()
		$('#courseSel').append require('views/course/item')(courses)
	
	render: ->
		@html.append require('views/course/show')(@item)
	
	changeCourse: ->
		@item = Course.find(@courseSel.val())
		Spine.trigger('changeCourse', @item)
		#@render

module.exports = Courses
