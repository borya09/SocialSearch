package com.borja.socialsearch.domain

import org.bson.types.ObjectId



class Item {

    static jsonProperties = [short:['title','imageUrl','previewUrl','description']]

    ObjectId id

    String sid     //Identification of the Item in the original site with the siteKey as prefix

    String title,
            imageUrl, //Url of the image, in case it's a photo
            previewUrl, //Url of the preview, in case it's a photo
            description,
            siteUrl  //Url of the site

    static belongsTo = [ site : Site]

    Date dateCreated

    List location


    static constraints = {
        sid nullable: false, blank: false, unique: 'site'
        title nullable: true
        imageUrl nullable: true
        previewUrl nullable: true
        description nullable: true
        siteUrl nullable: true

    }

    static mapping = {
        version false
        sid index:true
        location geoIndex:true
    }


}
