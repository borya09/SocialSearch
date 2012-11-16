package com.borja.socialsearch.services

import com.borja.socialsearch.apis.IApi
import com.borja.socialsearch.apis.ApiFactory

class HarvestService {

    def gather(tag) {

        IApi collector = ApiFactory.getInstance(tag)

        def items = collector.searchItems()

    }
}
