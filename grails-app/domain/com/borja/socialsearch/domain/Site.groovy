package com.borja.socialsearch.domain

import org.bson.types.ObjectId

class Site {

    Site() {
        item = []
    }

    ObjectId id

    String key     //Key of the site (TW:Twitter, IN:Instagram)

    static hasMany = [item: Item]
    static belongsTo = [tag: Tag]

    Date dateCreated
    Date lastUpdated

    static constraints = {
        key nullable: false, blank: false, size: 3..3, unique: 'tag'
    }

    static mapping = {
        version false
    }
}
