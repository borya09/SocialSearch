package com.borja.socialsearch.domain

import org.bson.types.ObjectId


class Item {

    ObjectId id

    String sid     //Identification of the Item in the original site with the siteKey as prefix

    String title,
            imageUrl, //Url of the image, in case it's a photo
            previewUrl, //Url of the preview, in case it's a photo
            description,
            siteUrl  //Url of the site


    Date dateCreated

    List loc


    static constraints = {
        sid nullable: false, blank: false
        title nullable: true
        imageUrl nullable: true
        previewUrl nullable: true
        description nullable: true
        siteUrl nullable: true

    }

    static mapping = {
        version false
        loc geoIndex:true, indexAttributes:[min:-500, max:500]
    }


}
