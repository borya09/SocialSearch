import com.borja.socialsearch.domain.Tag
import grails.converters.JSON

import org.codehaus.groovy.grails.web.converters.marshaller.json.GroovyBeanMarshaller
import com.borja.socialsearch.json.CustomDomainClassJSONMarshaller
import com.borja.socialsearch.json.JSONConstants


class BootStrap {

    def grailsApplication

    def init = { servletContext ->

        registerCustomJSONMarshallers()

    }
    def destroy = {
    }


    void registerCustomJSONMarshallers() {
        JSON.createNamedConfig(JSONConstants.CUSTOM_JSON_MARSHALLER_GROUP){
            it.registerObjectMarshaller(new CustomDomainClassJSONMarshaller(grailsApplication), 2)
        }

        JSON.createNamedConfig(JSONConstants.SHORT_JSON_MARSHALLER_GROUP){
            it.registerObjectMarshaller(new CustomDomainClassJSONMarshaller(grailsApplication, JSONConstants.SHORT_JSON_MARSHALLER_GROUP), 2)
        }
    }
}
