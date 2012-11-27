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

    def ownProps,  // Properties of the API (for all the tags)
        tagProps, //Properties of the tag for this API
        url,
        apiKey

    int connTimeout,
        readTimeout,
        max

    abstract def searchItems(tag)

    def launchSearch(params){
        def client = new RESTClient(url)
        params << [connectTimeout: connTimeout, readTimeout: readTimeout]
        return client.get(params)
    }

}
