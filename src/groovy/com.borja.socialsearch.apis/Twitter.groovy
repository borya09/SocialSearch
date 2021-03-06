package com.borja.socialsearch.apis

import com.borja.socialsearch.domain.Item


public class Twitter extends Api {


    @Override
    List<Item> searchItems(tag) {

        def items = []

        def response = launchSearch(
                query: [
                        q: "%23$tag"

                ]
        )

        def sid
        response.json.results?.each { tweet ->
            sid = tweet.id_str
            if (isNew(sid)) {
                items << new Item(
                        sid: sid,
                        previewUrl: tweet.profile_image_url,
                        imageUrl: "https://twitter.com/${tweet.from_user}/status/${sid}",
                        title: tweet.text
                )
            }
        }


        return items
    }
}