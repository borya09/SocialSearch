package com.borja.socialsearch.apis

import com.borja.socialsearch.domain.Item


class Panoramio extends Api {

    @Override
    List<Item> searchItems(tag) {

        def items = []

        def response = launchSearch(
                query: [
                        order: "popularity",
                        set: "full",
                        from: "0",
                        to: "20",
                        minx: -2.81,
                        miny: 43.30,
                        maxx: -2.99,
                        maxy: 43.40,
                        size: "medium"
                ]
        )


        def sid
        response.json.photos?.each { photo ->
            sid = photo.photo_id
            if (isNew(sid)) {
                items << new Item(
                        sid: sid,
                        previewUrl: photo.photo_file_url,
                        imageUrl: photo.photo_url,
                        title: photo.photo_title
                )
            }
        }


        return items
    }

}
