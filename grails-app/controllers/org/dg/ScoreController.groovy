package org.dg

import grails.converters.JSON

class ScoreController {
    static scaffold = true

    def scoreService

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
}
