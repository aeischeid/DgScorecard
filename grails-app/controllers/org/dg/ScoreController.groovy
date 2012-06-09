package org.dg

import grails.converters.JSON
import grails.plugins.springsecurity.Secured

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

@Secured('isAuthenticated()')
class ScoreController {
    static scaffold = true

    def scoreService

    def list() {
        def scores = scoreService.findScoresForCurrentUser()

        withFormat {
            html {
                render(view: "list", model: [scoreList: scores])
            }
            json {
                render scores as JSON
            }
        }
    }

    def save() {
        Score score = scoreService.create(params)

        if (!score.hasErrors()) {
            withFormat {
                html {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'score.label', default: 'Score'), score.id])
                    redirect(action: "show", id: score.id)
                }
                json {
                    response.status = 201

                    render score as JSON
                }
            }
        } else {
            withFormat {
                html {
                    render(view: "create", model: [score: score])
                }
                json {
                    response.status = 400
                    render score.errors as JSON
                }
            }
        }
    }

    def inProgress() {
        def inProgressScores = scoreService.findInProgressScores()

        render inProgressScores as JSON
    }
}
