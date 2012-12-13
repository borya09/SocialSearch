package socialsearch

import com.borja.socialsearch.domain.Tag
import grails.converters.JSON
import com.borja.socialsearch.json.JSONConstants


class TagController {



    def list() {
        //response.setHeader("Cache-Control", "no-store")
        //def tags = Tag.findAll()

        JSON.use(JSONConstants.SHORT_JSON_MARSHALLER_GROUP){

            render Tag.list() as JSON

        }



    }
}
