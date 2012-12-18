class UrlMappings {

    static mappings = {

        "/tag/$id"(controller: "request") {
            action = [GET: "itemsByTag"]
        }


        "/"(view: "/index")
        "500"(view: '/error')
    }
}
