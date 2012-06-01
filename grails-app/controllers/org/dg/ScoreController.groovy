package org.dg

/**
 * Access layer to Score resource/domain
 *
 * @GET /api/score
 * <p> Type: JSON
 * <p> Description: List of scores
 * <p> Posible Responses: 404,200
 *
 * @POST /api/score
 * <p> Type: JSON
 * <p> Description: Create a new score record
 * <p> Posible Responses: 400, 201
 *
 * @GET /api/score/:id
 * <p> Type: JSON
 * <p> Description: retrieve a score record by id
 * <p> Posible Responses: 400, 404, 200
 *
 * @DELETE /api/score/:id
 * <p> Type: JSON
 * <p> Description: delete a score record by id
 * <p> Posible Responses: 400, 403, 404, 204
 *
 * @PUT /api/score/:id
 * <p> Description: update score record by id
 * <p> Optional Params: score, notes, player.id, course.id 
 * <p> Posible Responses: 400, 403, 404, 200
 */

class ScoreController {
    static scaffold = true
}
