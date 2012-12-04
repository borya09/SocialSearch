package com.borja.socialsearch.services

class BackgroundHarvestService {

    def harvestService
    def grailsApplication

    def collectAndSave() {

        def tags = grailsApplication.config.tags

        for (tag in tags) {
            processTag(tag.key, tag.value)
        }
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
