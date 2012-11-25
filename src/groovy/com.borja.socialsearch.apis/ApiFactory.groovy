package com.borja.socialsearch.apis

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/16/12
 * Time: 1:26 AM
 * To change this template use File | Settings | File Templates.
 */
class ApiFactory {


    static def getInstance(siteKey) {

        def props = ApiFactory.config.sites[siteKey]
        println props
        def timeouts = ApiFactory.config.timeouts.apis
        println timeouts
        def className = props.clazz
        def clazz = ApiFactory.class.classLoader.loadClass(className)
        Api instance = (Api)clazz.newInstance(
                siteKey:siteKey,
                url:props.connection.url,
                apiKey:props.connection.apiKey,
                connTimeout:timeouts.connection,
                readTimeout:timeouts.read,
                properties:props.ownProps

        )


        return instance

    }

}
