Spine  = require('spine')
Course = require('models/course')
Scorecards = require('controllers/scorecards')

class Courses extends Spine.Controller
	events:
		'change #courseSel':'changeCourse'
	
	elements:
		'#courseSel'    :'courseSel'
		'#courseFilter' :'filter'
	
	constructor: ->
		super
		@html require('views/course/selector')
		Course.bind 'refresh', @list
		
	list: (filter)->
		#if filter
		#else
		courses = Course.all()
		$('#courseSel').append require('views/course/item')(courses)
	
	render: ->
		@html.append require('views/course/show')(@item)
	
	changeCourse: ->
		@log('change it!')
		@item = Course.find(@courseSel.val())
		Scorecards.setCourse(@courseSel.val())
		@log("to #{@item.name}")
		#@render

module.exports = Courses
