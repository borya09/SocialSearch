package com.borja.socialsearch.apis



/**
 * Created with IntelliJ IDEA.
 * User: borja
 * Date: 12/4/12
 * Time: 11:49 PM
 * To change this template use File | Settings | File Templates.
 */
import org.apache.commons.logging.*

class Chrono {

    long init
    String name
    def log = LogFactory.getLog('chrono')

    def init(){
        init = System.currentTimeMillis()
        log.debug "init $name"
    }

    def finish(){
        log.debug "finish $name: ${System.currentTimeMillis() - init} msecs"
    }
}
