package org.dg.api

import functionaltestplugin.FunctionalTestCase
import org.codehaus.groovy.grails.web.json.JSONObject
import org.codehaus.groovy.grails.web.json.JSONArray

abstract class JsonRestApiFunctionalTestCase extends FunctionalTestCase {
    JSONObject getParsedJsonSingleElement() {
        grails.converters.JSON.parse(response.contentAsString)
    }

    JSONArray getParsedJsonArray() {
        grails.converters.JSON.parse(response.contentAsString)
    }

    void doJsonGet(String url, String username = "user1", String password = "pass1") {
        get(url) {
            headers['Accept'] = 'application/json'
            headers["Authorization"] = createBasicAuth(username, password)
        }
    }

    def doJsonPost(String url, String jsonBody, String username = "user1", String password = "pass1") {
        post(url) {
            headers['Accept'] = 'application/json'
            headers["Content-Type"] = "application/json;charset=UTF-8"
            headers["Authorization"] = createBasicAuth(username, password)
            body {
                jsonBody
            }
        }
    }

    void doJsonPut(String url, String jsonBody, String username = "user1", String password = "pass1") {
        put(url) {
            headers['Accept'] = 'application/json'
            headers["Content-Type"] = "application/json;charset=UTF-8"
            headers["Authorization"] = createBasicAuth(username, password)
            body {
                jsonBody
            }
        }
    }

    void doJsonDelete(String url, String username = "user1", String password = "pass1") {
        delete(url) {
            headers['Accept'] = 'application/json'
            headers["Authorization"] = createBasicAuth(username, password)
        }
    }

    String createBasicAuth(String username, String password) {
        String nonEncodedAuth = "${username}:${password}".toString()

        String basicAuthEncoded = "Basic " + nonEncodedAuth.bytes.encodeBase64().toString()

        return basicAuthEncoded
    }
}
