package com.borja.socialsearch



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Item)
class ItemTests {

    void testConstraints() {
        def item1 = new Item()
        assertFalse item1.validate()

        item1.preview = "http://item.preview1"
        assertFalse item1.validate()

        item1.link = "http://item.link1"
        assertFalse item1.validate()

        item1.id = "1"
        assertTrue item1.validate()
    }

    void testUnique() {

        def item2 = new Item(id: "3", link: "http://item.link2")

        def item3 = new Item(id: "3", link: "http://item.link3")
        mockForConstraintsTests(Item, [item3])

        assertFalse item2.validate()
        item2.id = "2"
        assertTrue item2.validate()

    }
}
