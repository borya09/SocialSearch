package com.borja.socialsearch.apis

import com.borja.socialsearch.domain.Item

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/15/12
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class Twitter extends Api {


    @Override
    List<Item> searchItems(tag) {

        def items = []

        def response = launchSearch(
                query: [
                        q: "%23$tag"

                ]
        )

        response.json.results?.collect { tweet ->

            items << new Item(
                    previewUrl: tweet.profile_image_url,
                    imageUrl: "https://twitter.com/${tweet.from_user}/status/${tweet.id_str}",
                    title: tweet.text
            )

        }


        return items
    }
}