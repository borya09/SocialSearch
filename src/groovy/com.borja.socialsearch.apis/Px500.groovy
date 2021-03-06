package com.borja.socialsearch.apis

import com.borja.socialsearch.domain.Item


class Px500 extends Api {


    @Override
    List<Item> searchItems(tag) {

        def items = []

        def response = launchSearch(
                query: [
                        term: tag,
                        type: "photos",
                        page: 1,
                        order: "date",
                        license_type: -1,
                        image_size: 3,
                        consumer_key: apiKey

                ]
        )


        def sid
        response.json.photos?.each { photo ->
            sid = photo.id
            if (isNew(sid)) {
                items << new Item(
                        sid: sid,
                        previewUrl: photo.image_url,
                        imageUrl: "http://500px.com/photo/${sid}",
                        title: photo.name
                )
            }
        }


        return items
    }

}
