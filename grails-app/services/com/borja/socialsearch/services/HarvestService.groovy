package com.borja.socialsearch.services

import com.borja.socialsearch.apis.Api
import com.borja.socialsearch.apis.ApiFactory

class HarvestService {

    def grailsApplication

    def collect(tag) {

        def items = []

        for (site in grailsApplication.config.apis.sites) {
            items << collect(tag, site.key)
        }

        return items

    }


    def collect(tag, siteKey) {

        def items = []

        try {

            def collector = ApiFactory.getInstance(siteKey)

            items = collector.searchItems(tag)

        } catch (e) {
            log.error "Error collecting tag #$tag in $siteKey: $e"
        }

        return items
    }


}

