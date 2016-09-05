package com.vivareal.model

import br.com.six2six.fixturefactory.Fixture
import com.vivareal.model.exceptions.InvalidCoordinateException
import spock.lang.Specification

import javax.validation.Validator

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates
import static javax.validation.Validation.buildDefaultValidatorFactory

class RealStateTest extends Specification {

    Validator validator

    def setup() {
        loadTemplates("com.vivareal.model.templates");
        validator = buildDefaultValidatorFactory().getValidator();
    }

    def "Not allow out of province X coordinate"() {

        given: "A user created a valid real State"
            Property realEstate = Fixture.from(Property.class).gimme("valid")

        when: "changed the province X coordinate to out of province area"
            realEstate.setCoordinate(new Coordinate(20000 ,400))

        then: "A InvalidCoordinateException is thrown !!!"
            thrown InvalidCoordinateException
    }

    def "Not allow out of province Y coordinates"() {
        given: "A user created a valid real State"
            Property realEstate = Fixture.from(Property.class).gimme("valid")

        when: "changed the province X coordinate to out of province area"
            realEstate.setCoordinate(new Coordinate(333,222200))

        then: "A InvalidCoordinateException is thrown !!!"
            thrown InvalidCoordinateException
    }

    def "Not allow less than 1 bath"() {

        given: "A user whant to create a real estate"
            Property realEstate = Fixture.from(Property.class).gimme("valid")

        and: "Try to change the baths property to less than 1"
            realEstate.setBaths(0);

        when: "Validate fields"
            def result = validator.validate(realEstate);

        then: "A validation error is generated"
            result.size() == 1
            result.first().message == "O número de banheiros deve estar entre 1 e 4."
    }

    def "Not allow mode than 5 bath"() {

        given: "A user want to create a real estate"
            Property realEstate = Fixture.from(Property.class).gimme("valid")

        and: "Try to change the number of to more than 1"
            realEstate.setBaths(100);

        when: "Validate fields"
            def result = validator.validate(realEstate);

        then: "A validation error is generated"
            result.size() == 1
            result.first().message == "O número de banheiros deve estar entre 1 e 4."
    }


    def "Not allow a area less 20 square meters"() {

        given: "A real estate is created"
            Property realEstate = Fixture.from(Property.class).gimme("valid")

        and: "someone changed the square meters property to less than 20"
            realEstate.setSquareMeters(15)

        when: "Validate fields"
            def result = validator.validate(realEstate);

        then: "A Exception os thown"
            result.size() == 1
            result.first().message == "A área deve estar entre 20 e 240 m2"
    }

    def "Not allow a area more than 240 square meters"() {

        given: "A real estate is created"
            Property realEstate = Fixture.from(Property.class).gimme("valid")

        and: "someone changed the square meters property to more than 240"
            realEstate.setSquareMeters(2000)

        when: "Validate fields"
            def result = validator.validate(realEstate);

        then: "A Exception os thown"
            result.size() == 1
            result.first().message == "A área deve estar entre 20 e 240 m2"

    }


}