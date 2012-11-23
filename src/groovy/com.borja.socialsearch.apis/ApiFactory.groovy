package com.borja.socialsearch.apis

/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 11/16/12
 * Time: 1:26 AM
 * To change this template use File | Settings | File Templates.
 */
class ApiFactory {


    static Api getInstance(siteKey) {

        def instance = null


        switch (siteKey){
            case 'INS':
                instance = new Instagram()
                break
            case "FLK":
                instance = new Instagram()
                break
        }

        instance.setSiteKey(siteKey)



        return instance

    }

}
