package com.borja.socialsearch.apis

import com.borja.socialsearch.domain.Item
import wslite.rest.RESTClient

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/15/12
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class Instagram extends Api{


    @Override
    def searchItems(tag, max) {

        url =  "${url[0]}/$tag/${url[1]}"

        def response = launchSearch(
                query:[
                        client_id:apiKey

                ]
        )

        def results = response.json.data?.collect{ photo->
            [
                    preview: photo.images.low_resolution.url,
                    link: photo.images.standard_resolution.url,
                    title: photo.caption.text
            ]
        }


        return results
    }
}