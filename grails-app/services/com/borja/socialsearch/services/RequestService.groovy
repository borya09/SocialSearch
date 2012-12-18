package com.borja.socialsearch.services

import com.borja.socialsearch.domain.Tag

class RequestService {


    def grailsApplication
    def harvestService

    def requestItemsByTag(tag) {

        def items = [],
            stored = false

        if (tag in grailsApplication.config.tags*.key) {
            items = Tag.findByKey(tag)
            if (items){
                stored = true
            }
        }
        if (!stored){
            items = harvestService.collectTag(tag, null)
        }

        return [tag: items, stored: stored]
    }


    def requestItemsByGeoPos(pos) {

    }
}
