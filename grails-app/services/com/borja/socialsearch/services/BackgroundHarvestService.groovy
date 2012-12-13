package com.borja.socialsearch.services

import com.borja.socialsearch.apis.ApiFactory

class BackgroundHarvestService {

    def harvestService
    def grailsApplication

    def collectAndSave() {


        def chrono = ApiFactory.getChrono("collectAndSave", true)
        //chrono.init()

        def tags = grailsApplication.config.tags

        for (tag in tags) {
            processTag(tag.key, tag.value)
        }

        chrono.finish()
    }


    private def processTag(tagKey, tagConfig) {

        try {

            def tag = harvestService.collectTag(tagKey, tagConfig)
            tag.save(failOnError: true)

        } catch (e) {
            log.error "Error processing tag $tagKey: $e"
        }
    }
}
