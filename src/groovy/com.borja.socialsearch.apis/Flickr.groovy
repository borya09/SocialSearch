package com.borja.socialsearch.apis

import com.borja.socialsearch.domain.Item

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/15/12
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class Flickr extends Api {


    @Override
    List<Item> searchItems(tag) {

        def items = []

        def response = launchSearch(
                query: [
                        format: "json",
                        nojsoncallback: 1,
                        method: "flickr.photos.search",
                        api_key: apiKey,
                        tags: tag,
                        woe_id: tagProps.woeId,
                        privacy_filter: 1,
                        per_page: max,
                        page: 1
                ]
        )



        def sid

        response.json.photos?.photo?.each { photo ->
            sid = photo.id
            if (isNew(sid)){
                items << new Item(
                        sid: sid,
                        previewUrl: "http://farm${photo.farm}.staticflickr.com/${photo.server}/${sid}_${photo.secret}_n.jpg",
                        imageUrl: "http://www.flickr.com/photos/${photo.owner}/${sid}/",
                        title: photo.title

                )
            }
        }

        return items
    }
}