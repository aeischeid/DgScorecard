Spine = require('spine')

class Player extends Spine.Model
  @configure 'Player', 'name'
  @extend Spine.Model.Local
  
module.exports = Player
