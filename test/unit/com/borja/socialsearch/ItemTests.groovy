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
        def sid = "TWio34HJHJDS"
        def item = new Item()
        assertFalse item.validate()
        assert "nullable" == item.errors["sid"]
        assert "nullable" == item.errors["siteKey"]


        item.sid = sid
        item.siteKey = "TWEW"
        assertFalse item.validate()
        assert "size" == item.errors["siteKey"]

        item.siteKey = "TW"
        assertTrue item.validate()

        def item2 = new Item(sid: sid, siteKey: "TWEW")

        mockForConstraintsTests(Item,[item,item2])
        assertFalse item2.validate()
        assert "unique" == item2.errors["sid"]



    }

}
