package com.borja.socialsearch

class Item {

    String id, title, link, preview

    static constraints = {
        title nullable: true
        preview nullable: true
        id nullable: false

    }

    static mapping = {
        id type: 'string', generator:'assigned'
        version false
    }
}
