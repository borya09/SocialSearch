package com.borja.socialsearch.services

import grails.plugin.spock.UnitSpec

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/24/12
 * Time: 1:04 AM
 * To change this template use File | Settings | File Templates.
 */
class HarvestServiceSpec extends UnitSpec {

    def "when creating thesis a new book is created"() {
        setup:
        mockLogging(HarvestService, true)
        def harvestService = new HarvestService()



        when:
        def config = harvestService.mountConfig("INS")

        then:
        config != null
        config.connection != null
        config.connection ==     0


    }
}
