package com.borja.socialsearch



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Site)
class SiteTests {

    void testConstraints() {

        mockForConstraintsTests(Site)

        def site = new Site()
        assertFalse site.validate()
        assert "nullable" == site.errors["key"]


        site.key = "TWIT"
        assertFalse site.validate()
        assert "size" == site.errors["key"]

        site.key = "TWI"
        assertTrue site.validate()



        def site2 = new Site(key: "TWI")
        mockForConstraintsTests(Site, [site, site2])

        assertFalse site2.validate()
        assert "unique" == site2.errors["key"]


    }


}