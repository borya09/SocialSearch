package com.borja.socialsearch.apis

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/15/12
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class Twitter extends Api {


    @Override
    def searchItems(tag) {

        def response = launchSearch(
                query: [
                        q:"%23$tag"

                ]
        )

        def results = response.json.results?.collect { tweet ->
            [
                    preview: tweet.profile_image_url,
                    link: "https://twitter.com/${tweet.from_user}/status/${tweet.id_str}",
                    title: tweet.text
            ]
        }


        return results
    }
}