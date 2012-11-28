package com.borja.socialsearch.services

import com.borja.socialsearch.apis.ApiFactory

class HarvestService {

    def grailsApplication

    def collect(tag) {

        def items = []
        def config = retrieveConfig4Tag(tag)

        for (site in grailsApplication.config.apis.sites) {
            items += collect(tag, site.key, config)
        }

        return items

    }


    def collect(tag, siteKey, config) {

        def items = []

        try {

            config = config ?: retrieveConfig4Tag(tag)

            def apiConfig = retrieveConfig4Site(config, siteKey)

            def collector = ApiFactory.getInstance(siteKey, apiConfig)

            items = collector.searchItems(tag)

        } catch (e) {
            log.error "Error collecting tag #$tag in $siteKey: $e"
        }

        return items
    }

    private def retrieveConfig4Tag(tag) {
        def config = grailsApplication.config
        return [apis: config.apis, tag: config.tags[tag]]
    }

    private def retrieveConfig4Site(config, siteKey) {
        def tag = [:]
        if ("defaults" in config.tag) {
            tag += config.tag.defaults
        }
        if ("siteKey" in config.tag) {
            tag += config.tag[siteKey]
        }
        return [tag: tag, site: config.apis.sites[siteKey], timeouts: config.apis.timeouts, connection: config.apis.connection]
    }
}

