package com.borja.socialsearch.apis

import com.borja.socialsearch.domain.Item
import wslite.rest.RESTClient

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/22/12
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class Api {

    String siteKey,
           siteName

    def properties,
        url,
        apiKey

    int connTimeout,
        readTimeout

    abstract def searchItems(tag, max)

    def launchSearch(params){
        params << [connectTimeout: connTimeout, readTimeout: readTimeout]
        println(params)
        def client = new RESTClient(url)
        return client.get(params)
    }

}
