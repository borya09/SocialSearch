package com.borja.socialsearch.apis

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/16/12
 * Time: 1:26 AM
 * To change this template use File | Settings | File Templates.
 */
class ApiFactory {


    static def getInstance(siteKey, config) {



        def siteProps = config.site
        def tagProps = config.tag
        def timeouts = config.timeouts
        def max = config.connection.max

        def className = siteProps.clazz
        def clazz = ApiFactory.class.classLoader.loadClass(className)
        Api instance = (Api)clazz.newInstance(
                siteKey:siteKey,
                url:siteProps.connection.url,
                apiKey:siteProps.connection.apiKey,
                connTimeout:timeouts.connection,
                readTimeout:timeouts.read,
                ownProps:siteProps.ownProps,
                tagProps:tagProps,
                max:max
        )


        return instance

    }

}
