import com.borja.socialsearch.domain.Item
import com.borja.socialsearch.apis.ApiFactory

class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        ApiFactory.metaClass.'static'.getConfig = { -> grailsApplication.config}
    }
    def destroy = {
    }
}
