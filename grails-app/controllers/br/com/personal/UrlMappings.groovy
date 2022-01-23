package br.com.personal

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/teste"(view:"/layouts/layoutplugin")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
