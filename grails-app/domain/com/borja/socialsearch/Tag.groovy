package com.borja.socialsearch

import org.bson.types.ObjectId

class Tag {

    ObjectId id

    String key //real tag

    Date dateCreated

    List<Item> items

    static constraints = {
        key nullable: false, blank: false, unique: true
    }

    static mapping = {
        version false
    }

}
