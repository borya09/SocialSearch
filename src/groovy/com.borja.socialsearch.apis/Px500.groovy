package com.borja.socialsearch.apis

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/28/12
 * Time: 12:07 AM
 * To change this template use File | Settings | File Templates.
 */
class Px500 extends Api{


    @Override
    def searchItems(tag) {

        def response = launchSearch(
                query: [
                        term:tag,
                        type:"photos",
                        page:1,
                        order:"date",
                        license_type:-1,
                        image_size:3,
                        consumer_key:"hXKyWmjRBZw4bFsz8p6krD9uk3VUIzyJoE1z27gl"

                ]
        )



        def results = response.json.photos?.collect { photo ->
            [
                    preview: photo.image_url,
                    link: "http://500px.com/photo/${photo.id}",
                    title: photo.name
            ]
        }


        return results
    }

}
