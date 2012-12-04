package com.borja.socialsearch.domain

import org.bson.types.ObjectId

class Tag {

    Tag() {
        site = []
    }

    ObjectId id

    String key //real tag

    Date dateCreated
    Date lastUpdated


    static hasMany = [site: Site]

    static constraints = {
        key nullable: false, blank: false, unique: true
    }

    static mapping = {
        version false
    }

}
