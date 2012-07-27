
describe 'Scorecards', ->
  ScorecardsTests = require 'controllers/scorecardsTests'
  Player = require '../app/models/player'
  Scorecard = require '../app/controllers/scorecards'
  #new Player(name:'bob', scores:{})
  
  it 'CanCalcScoreTally', ->
    #player = new Player()
    player =
      scores:
        '1':3
        '2':2
        '3':-1
        '4':0
        '5':-1
    #player.scores['1'] = 2
    #player.scores['2'] = 3
    #player.scores['3'] = -1
    #player.scores['4'] = 0
    #player.scores['5'] = -1
    console.log 'Player', Player
    console.log 'Scorecard', Scorecard
    console.log 'ScorecardsTests', ScorecardsTests
    
    scorecard = ScoreMain.create()
    expect( scorecard.calcScoreTally(player) ).toEqual 3

  it 'can add', ->
    expect(1 + 1).toBe(2)

 

