package socialsearch

import com.borja.socialsearch.domain.Tag
import grails.converters.JSON
import com.borja.socialsearch.json.JSONConstants


class RequestController {


    def requestService

    def itemsByTag() {

        response.setHeader("Cache-Control", "no-store")

        if (params.id) {
            JSON.use(JSONConstants.SHORT_JSON_MARSHALLER_GROUP) {
                render requestService.requestItemsByTag(params.id) as JSON
            }
        } else {
            response.status = 404
        }

    }
}
