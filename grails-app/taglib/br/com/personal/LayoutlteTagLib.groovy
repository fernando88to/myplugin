package br.com.personal

class LayoutlteTagLib {
    static namespace = 'layout'
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def oi = { attrs, body ->
        out << "oi do plugin"
    }

}
