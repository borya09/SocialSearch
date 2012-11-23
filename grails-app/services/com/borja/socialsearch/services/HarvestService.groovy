package com.borja.socialsearch.services

import com.borja.socialsearch.apis.Api
import com.borja.socialsearch.apis.ApiFactory

class HarvestService {

    def grailsApplication

    def gather(tag, siteKey, max) {

        def collector = ApiFactory.getInstance(siteKey)
        def config = [:]
        def items = collector.searchItems(tag, max, config)

        return items

    }
}
