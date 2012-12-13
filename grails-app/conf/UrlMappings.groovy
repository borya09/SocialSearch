class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }
        "/rest/tag/$id"(controller: "tag") {
            action = [GET: "list"]
        }
        "/"(view: "/index")
        "500"(view: '/error')
    }
}
