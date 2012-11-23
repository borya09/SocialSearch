package com.borja.socialsearch.apis

import com.borja.socialsearch.domain.Item

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/22/12
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class Api {

    String siteKey

    int connTimeout,
            readTimeout

    abstract List<Item> searchItems(tag, max, config)

}
