package com.borja.socialsearch.domain

import org.bson.types.ObjectId

class Tag {

    ObjectId id

    String key //real tag

    Date dateCreated

    List<Site> sites

    static constraints = {
        key nullable: false, blank: false, unique: true
    }

    static mapping = {
        version false
    }

}
