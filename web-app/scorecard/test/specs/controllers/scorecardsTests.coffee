require     = window.require
App         = require "../index"
#Player      = require '../models/player'
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

  it 'can add', ->
    expect(1 + 1).toBe(2)
