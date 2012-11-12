


environments {
    development {
        grails {
            mongo {
                host = "localhost"
                port = 27017
                databaseName = "test"
            }
        }

    }
    test{

    }
    production{
        grails {
            mongo {
                host = "localhost"
                port = 27017
                databaseName = "test"
            }
        }
    }
}