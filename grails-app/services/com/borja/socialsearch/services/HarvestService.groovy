package com.borja.socialsearch.services

import com.borja.socialsearch.apis.ApiFactory
import com.borja.socialsearch.domain.Tag
import com.borja.socialsearch.domain.Site
import com.borja.socialsearch.domain.Item

class HarvestService {

    def grailsApplication


    def collectTag(tagKey, tagConfig) {

        def tag = searchOrCreateTag(tagKey)

        def site

        for (siteKey in grailsApplication.config.apis.sites*.key) {
            site = collectSite(tag, siteKey, tagConfig)
            if (site) {
                tag.addToSite(site)
            }
        }

        return tag

    }




    def collectSite(tag, siteKey, tagConfig) {

        def site,
            tagKey

        try {

            tagKey = tag.key

            site = searchOrCreateSite(tag, siteKey)

            def items = collectItems(siteKey, tagKey, tagConfig)

            items.each { item ->
                site.addToItem(item)
            }

        } catch (e) {
            log.error "Error collecting site with tag #$tagKey in $siteKey: $e"
        }

        return site
    }


    def collectItems(siteKey, tagKey, tagConfig) {
        def items = []

        try {

            def apiConfig = retrieveConfig4Site(tagConfig, siteKey)

            def collector = ApiFactory.getCollectorInstance(tagKey, siteKey, apiConfig)

            items = collector.searchItems(tagKey)

        } catch (e) {
            log.error "Error collecting items with tag #$tagKey in $siteKey: $e"
        }

        return items
    }


    private def searchOrCreateTag(tagKey) {
        def tag = Tag.findByKey(tagKey)

        if (!tag) {
            tag = new Tag(key: tagKey)
        }

        return tag
    }

    private def searchOrCreateSite(tag, siteKey) {
        def site = Site.findByTagAndKey(tag, siteKey)

        if (!site) {
            site = new Site(key: siteKey, tag: tag)
        }

        return site
    }


    private def retrieveConfig4Site(tagConfig, siteKey) {

        def apisConfig = grailsApplication.config.apis,
            tag = [:]

        if (tagConfig) {
            def props = tagConfig[siteKey]
            if (props) {
                tag += props
            }
            props = tagConfig.defaults
            if (props) {
                tag += props
            }
        }

        return [
                tag: tag,
                site: apisConfig.sites[siteKey],
                timeouts: apisConfig.timeouts,
                connection: apisConfig.connection
        ]
    }
}

