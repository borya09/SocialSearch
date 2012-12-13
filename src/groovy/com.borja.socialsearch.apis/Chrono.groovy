package com.borja.socialsearch.apis




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
