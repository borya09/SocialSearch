package com.borja.socialsearch.apis

import com.borja.socialsearch.domain.Item

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/15/12
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class Instagram extends Api {


    @Override
    List<Item> searchItems(tag) {

        def items = []

        url = "${url[0]}/$tag/${url[1]}"

        def response = launchSearch(
                query: [
                        client_id: apiKey
                ]
        )

        def sid
        response.json.data?.each { photo ->
            sid = photo.id
            if (isNew(sid)) {
                items << new Item(
                        sid: sid,
                        previewUrl: photo.images.low_resolution.url,
                        imageUrl: photo.link,
                        title: photo.caption.text
                )
           }
        }



        return items
    }
}