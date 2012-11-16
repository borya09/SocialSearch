package com.borja.socialsearch.domain

import org.bson.types.ObjectId

class Site {

    ObjectId id

    String key     //Key of the site (TW:Twitter, IN:Instangram)

    List<Item> items

    static constraints = {
        key nullable: false, blank: false, size: 3..3, unique: true
    }

    static mapping = {
        version false
    }
}
