package com.borja.socialsearch.apis

import com.borja.socialsearch.domain.Item
import wslite.rest.RESTClient
import com.borja.socialsearch.domain.Site
import com.borja.socialsearch.domain.Tag


abstract class Api {

    String tagKey,
           siteKey,
           siteName

    def ownProps,  // Properties of the API (for all the tags)
        tagProps, //Properties of the tag for this API
        url,
        apiKey

    int connTimeout,
        readTimeout,
        max

    abstract List<Item> searchItems(tag)

    def launchSearch(params) {
        def client = new RESTClient(url)
        params << [connectTimeout: connTimeout, readTimeout: readTimeout]
        return client.get(params)
    }

    def isNew(sid){
        return !Item.findBySid(sid)
    }



}
