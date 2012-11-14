package com.borja.socialsearch


class Item {


    String sid     //Identification of the Item in the original site

    String title,
            imageUrl, //Url of the image, in case it's a photo
            previewUrl, //Url of the preview, in case it's a photo
            description,
            siteUrl,  //Url of the site
            siteKey     //Key of the site (TW:Twitter, IN:Instangram)

    Date dateCreated

    List loc


    static constraints = {
        sid unique: true, nullable: false, blank: false
        title nullable: true
        imageUrl nullable: true
        previewUrl nullable: true
        description nullable: true
        siteUrl nullable: true
        siteKey nullable: false, blank: false, size: 2..2
    }

    static mapping = {
        version false
        loc geoIndex:true, indexAttributes:[min:-500, max:500]
    }


    def beforeInsert(){
        sid = siteKey + sid
    }
}
