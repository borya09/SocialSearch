package socialsearch

import grails.converters.JSON

class PruebaController {

    def harvestService

    def index() {
        render harvestService.collect("bilbao") as JSON
    }
}
