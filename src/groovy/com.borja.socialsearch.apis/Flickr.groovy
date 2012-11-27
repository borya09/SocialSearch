package com.borja.socialsearch.apis

import wslite.rest.RESTClient

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/15/12
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class Flickr extends Api{


    @Override
    def searchItems(tag) {

        def response = launchSearch(
                query:[
                        format:"json",
                        nojsoncallback:1,
                        method:"flickr.photos.search",
                        api_key:apiKey,
                        tags:tag,
                        woe_id:tagProps.woeId,
                        privacy_filter:1,
                        per_page:max,
                        page:1
                ],
        )


        def results = response.json.photos.photo?.collect{ photo->
            [
                    preview: "http://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}_n.jpg",
                    link: "http://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}_b.jpg",
                    title: photo.title
            ]
        }


        return results
    }
}