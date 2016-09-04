package com.vivareal.model

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import com.vivareal.exceptions.InvalidCoordinateException
import spock.lang.Specification

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates

class RealStateTest extends Specification {

    def setup() {
        loadTemplates("com.vivareal.model.templates");
    }


    def "Not allow out of province x coordinate"() {

        given: "A user created a valid real State"
            RealEstate realEstate = Fixture.from(RealEstate.class).gimme("valid")

        when: "A user try a out of province coordinate "
            realEstate.setCoordinate(new Coordinate(10000,200))

        then: "A InvalidCoordinateException is thrown !!!"
            thrown InvalidCoordinateException
    }

    def "Not allow out of province y coordinate"() {

        given: "A user created a valid real State"
            RealEstate realEstate = Fixture.from(RealEstate.class).gimme("valid")

        when: "A user try a out of province coordinate "
            realEstate.setCoordinate(new Coordinate(333,222200))

        then: "A InvalidCoordinateException is thrown !!!"
            thrown InvalidCoordinateException
    }

    def "Not allow less than 1 bath"() {

        given: "A user whant to create a real estate"
        when: "Try to change the number of to less than 1"
        then: "A Exception is thrown"
            thrown Exception

    }

    def "Not allow mode than 5 bath"() {

        given: "A user want to create a real estate"
        when: "Try to change the number of to more than 1"
        then: "A Exception os thown"
            thrown Exception

    }


    def "Not allow a area less 20 square meters"() {

        given: "A user want to create a real estate"
        when: "Try to change the square meters to less than 20"
        then: "A Exception os thown"
            thrown Exception

    }

    def "Not allow a area more than 240 square meters"() {

        given: "A user want to create a real estate"
        when: "Try to change the square meters to  more than 240"
        then: "A Exception os thown"
            thrown Exception

    }

    def "Validate coordinate for conflict zone"() {

        given: "A user created a real estate"
            RealEstate realEstate = Fixture.from(RealEstate.class).gimme("valid")

        when: "the coordinate is in conflict zone"
            realEstate.setCoordinate(new Coordinate(450,900))
        then: "The provinces should be SCAVY and GODE"

            realEstate.getProvinces().size() == 2
    }

    def "Validate coordinate out of conflict zone"() {

        given: "A user created a real estate"
            RealEstate realEstate = Fixture.from(RealEstate.class).gimme("valid")

        when: "the coordinate is out of conflict zone"
            realEstate.setCoordinate(new Coordinate(450,900))

        then: "the number of provinces shold be 1"
            realEstate.getProvinces().size() == 2
    }


}