package com.borja.socialsearch



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Item)
class ItemTests {

    void test() {
        def item0 = new Item(title: "titulo")
        assertFalse item0.validate()

    }

    void testConstraints() {
        def item1 = new Item()
        assertFalse item1.validate()

        item1.preview = "http://item.preview1"
        assertFalse item1.validate()

        item1.link = "http://item.link1"
        assertFalse item1.validate()


    }

}
