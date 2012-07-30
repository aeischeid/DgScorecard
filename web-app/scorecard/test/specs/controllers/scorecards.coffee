require = window.require

describe 'Scorecards', ->
  ScoreMain = require('controllers/scorecards')
  Player = require('models/player')

  beforeEach ->
    Player.create( name: 'Fred' )
    Player.create( name: 'Bob'  )

  afterEach ->
    Player.deleteAll()

  it 'Return number of Players', ->
    expect(Player.count()).toBe(2)

  it 'Remove All Players', ->
    Player.deleteAll()
    expect(Player.count()).toBe(0)

