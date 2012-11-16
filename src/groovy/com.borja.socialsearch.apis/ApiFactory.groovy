package com.borja.socialsearch.apis

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/16/12
 * Time: 1:26 AM
 * To change this template use File | Settings | File Templates.
 */
class ApiFactory {


    static IApi getInstance(siteKey){

        def instance = null

        if (siteKey.toString().equalsIgnoreCase("INS")){
            instance =  new Instagram()
        }

        return instance

    }

}
