package socialsearch

import grails.converters.JSON

class PruebaController {

    def backgroundHarvestService

    def index() {
        backgroundHarvestService.collectAndSave()
        return [ok:"true"] as JSON
    }
}
