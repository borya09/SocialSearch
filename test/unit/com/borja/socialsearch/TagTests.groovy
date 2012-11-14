package com.borja.socialsearch

import grails.test.mixin.TestFor


@TestFor(Tag)
class TagTests {


    void testConstraints() {

        mockForConstraintsTests(Tag)

        def tag = new Tag(),
            bilbao = new Tag(key: "bilbao"),
            bilbao2 = new Tag(key: "bilbao")

        mockForConstraintsTests(Tag)

        assertFalse tag.validate()
        assert "nullable" == tag.errors["key"]


        assertTrue bilbao.validate()

        mockForConstraintsTests(Tag, [bilbao, bilbao2])
        assertFalse bilbao2.validate()
        assert "unique" == bilbao2.errors["key"]


    }


}
