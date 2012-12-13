package com.borja.socialsearch.apis

import org.apache.commons.logging.LogFactory
import org.apache.log4j.Logger


class ApiFactory {


    static def getCollectorInstance(tagKey, siteKey, config) {

        def siteProps = config.site
        def tagProps = config.tag
        def timeouts = config.timeouts
        def max = config.connection.max

        def className = siteProps.clazz
        def clazz = ApiFactory.class.classLoader.loadClass(className)
        Api instance = (Api) clazz.newInstance(
                tagKey: tagKey,
                siteKey: siteKey,
                url: siteProps.connection.url,
                apiKey: siteProps.connection.apiKey,
                connTimeout: timeouts.connection,
                readTimeout: timeouts.read,
                ownProps: siteProps.ownProps,
                tagProps: tagProps,
                max: max
        )


        return instance

    }


    static def getChrono(name, init = false) {
        def chrono = new Chrono(name: name)
        if (init){
            chrono.init()
        }
        return chrono
    }


}
