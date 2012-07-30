Spine = require('spine')
Ajax  = require('spine/lib/local')

class Player extends Spine.Model
  @configure 'Player', 'name', 'scores'
  @extend Spine.Model.Local
  
module.exports = Player
