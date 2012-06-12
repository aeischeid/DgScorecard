Spine = require('spine')

class Player extends Spine.Model
  @configure 'Player', 'name', 'scores'
  @extend Spine.Model.Local
  
module.exports = Player
