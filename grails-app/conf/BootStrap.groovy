import com.borja.socialsearch.domain.Item
import com.borja.socialsearch.apis.ApiFactory

class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        //TODO Not working after redeploy: "config: not such property ..."
        //ApiFactory.metaClass.static.getConfig = { -> grailsApplication.config}
    }
    def destroy = {
    }
}
