package com.borja.socialsearch.apis

import com.borja.socialsearch.domain.Item

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/16/12
 * Time: 1:24 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IApi {

    List<Item> searchItems(tag, siteKey, max, connTimeout, readTimeout)

}