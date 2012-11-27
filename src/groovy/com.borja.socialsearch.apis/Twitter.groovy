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

        url = url + tag

        def response = launchSearch([])

        def results = response.json.results?.collect { tweet ->
            [
                    preview: "",
                    link: "",
                    title: tweet.text
            ]
        }


        return results
    }
}