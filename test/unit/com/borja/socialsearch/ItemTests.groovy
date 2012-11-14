package com.borja.socialsearch



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Item)
class ItemTests {


    void testConstraints() {

        mockForConstraintsTests(Item)

        def item = new Item()
        assertFalse item.validate()
        assert "nullable" == item.errors["sid"]
        assert "nullable" == item.errors["siteKey"]


        item.sid = "TWio34HJHJDS"
        item.siteKey = "TWEW"
        assertFalse item.validate()
        assert "size" == item.errors["siteKey"]

        item.siteKey = "TW"
        assertTrue item.validate()


    }

}
