package com.vivareal.model

import spock.lang.Specification

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates

class ProvinceTest extends Specification {

    void setup() {
        loadTemplates("com.vivareal.model.templates");
    }


    def "Return true when coordinate is inside province"() {

        given: "the GODE province"
            Province jaby = Province.GODE

        when: "Check if coordinate (10, 900) is inside province"
            def result = jaby.isInsideProvince(new Coordinate(10,900))

        then: "The result should be true"
            result == true

    }

    def "Return false when coordinate is outside province"() {

        given: "the GODE province"
        Province jaby = Province.GODE

        when: "Check if coordinate (10, 300) is inside province"
        def result = jaby.isInsideProvince(new Coordinate(10,300))

        then: "The result should be false"
        result == false
    }

}
