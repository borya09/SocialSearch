package com.borja.socialsearch

class Item {

    String title, link, preview

    static constraints = {
        title nullable: true
        preview nullable: true
    }

    static mapping = {
        version false
    }
}
