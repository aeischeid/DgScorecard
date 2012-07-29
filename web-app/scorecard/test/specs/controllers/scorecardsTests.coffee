require     = window.require
App         = require "../index"
Player      = require '../models/player'
Scorecards  = require '../controllers/scorecards'

describe 'ScorecardsTests', ->
  #ScorecardsTests = require 'controllers/scorecardsTests'
  #new Player(name:'bob', scores:{})
  #console.log Player

  it 'CanCalcScoreTally', ->
    player =
      scores:
        '1':3
        '2':2
        '3':-1
        '4':0
        '5':-1
    scorecards = new Scorecards()
    expect( scorecards.calcScoreTally(player) ).toEqual 3

  it 'will fetch players when scorecard created', ->
    spyOn(Player, 'fetch')
    scorecards = new Scorecards()
    expect(Player.fetch).toHaveBeenCalled()

  it 'will render nine when course is reset', ->
    scorecards = new Scorecards()
    spyOn(scorecards, 'renderNine').andCallThrough()
    course =
      holes:18
      name:'testCourse'
    scorecards.resetCourse(course)
    expect(scorecards.renderNine).toHaveBeenCalled()

  it 'will render nine twice when course is 18 holes', ->
    scorecards = new Scorecards()
    spyOn(scorecards, 'renderNine').andCallThrough()
    course =
      holes:18
      name:'testCourse'
    scorecards.resetCourse(course)
    expect(scorecards.renderNine.calls.length).toEqual(2)
