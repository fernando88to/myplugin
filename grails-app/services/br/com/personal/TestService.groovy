package br.com.personal

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@Transactional
class TestService {

    @ReadOnly
    String  hello() {
        'Hello World'
    }
}
