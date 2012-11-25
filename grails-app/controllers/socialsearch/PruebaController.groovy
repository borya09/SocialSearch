package socialsearch

import grails.converters.JSON

class PruebaController {

    def harvestService

    def index() {
        render (harvestService.gather("bilbao", "INS", 200) + harvestService.gather("bilbao", "FLI", 200)) as JSON
    }
}
