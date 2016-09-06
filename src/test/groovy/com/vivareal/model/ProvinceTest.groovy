package com.vivareal.model

import spock.lang.Specification

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates
import static com.vivareal.model.Province.getProvincesForCoordinate

class ProvinceTest extends Specification {

    void setup() {
        loadTemplates("com.vivareal.templates");
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

    def "Return all provinces in a coordinate in conflict zone"() {

        given: "A coordinate of conflict zone"
            def coordinate = new Coordinate(450, 900)

        when: "get provinces for this coordinate"
            def provinces = getProvincesForCoordinate(coordinate)

        then: "Should return 2 provinces: GODE and RUJA"
            provinces.size() == 2
            provinces.contains(Province.GODE) == true
            provinces.contains(Province.RUJA) == true

    }

    def "Return a province out of conflict zone"() {

        given: "A coordinage out of conflict zone"
            def coordinate = new Coordinate(30, 900)

        when: "get provinces for this coordinate"
            def provinces = getProvincesForCoordinate(coordinate)

        then: "should return 1 province: GODE"
            provinces.size() == 1
            provinces.contains(Province.GODE)
    }



}
