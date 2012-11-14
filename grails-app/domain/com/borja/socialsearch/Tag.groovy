package com.borja.socialsearch

class Tag {

    String tag

    Date dateCreated, dateUpdated

    List<Item> items

    static constraints = {
        tag nullable: false, blank: false
    }
}
