package com.vivareal.controller.request

import br.com.six2six.fixturefactory.Fixture
import com.vivareal.model.Property
import spock.lang.Specification

import javax.validation.Validator

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates
import static javax.validation.Validation.buildDefaultValidatorFactory


class PropertyRequestTest extends Specification {

    Validator validator

    void setup() {
        loadTemplates("com.vivareal.fixtures");
        validator = buildDefaultValidatorFactory().getValidator();
    }

    def "Not allow less than 1 bath"() {

        given: "A user whant to create a Property with 0 baths"
            def request = Fixture.from(PropertyRequest.class).gimme("noBaths")

        when: "Validate fields"
            def result = validator.validate(request);

        then: "A validation error is generated"
            result.size() == 1
            result.first().message == "O valor precisa estar entre 1 e 4"
    }

    def "Not allow more than 4 bath"() {

        given: "A user whant to create a Property with 7 baths"
            def request = Fixture.from(PropertyRequest.class).gimme("soMuchBaths")

        when: "Validate fields"
            def result = validator.validate(request);

        then: "A validation error is generated"
            result.size() == 1
            result.first().message == "O valor precisa estar entre 1 e 4"
    }


    def "Not allow more than 0 beds"() {

        given: "A user whant to create a Property with 0 beds"
        def request = Fixture.from(PropertyRequest.class).gimme("noBeds")

        when: "Validate fields"
        def result = validator.validate(request);

        then: "A validation error is generated"
        result.size() == 1
        result.first().message == "O valor precisa estar entre 1 e 5"
    }

    def "Not allow more than 5 beds"() {

        given: "A user whant to create a Property with more than 5 beds"
        def request = Fixture.from(PropertyRequest.class).gimme("soMuchBeds")

        when: "Validate fields"
        def result = validator.validate(request);

        then: "A validation error is generated"
        result.size() == 1
        result.first().message == "O valor precisa estar entre 1 e 5"
    }

    def "Not allow less than 20 square meters"() {

        given: "A user whant to create a Property with less then 20 square meters"
            def request = Fixture.from(PropertyRequest.class).gimme("verySmallArea")

        when: "Validate fields"
            def result = validator.validate(request);

        then: "A validation error is generated"
            result.size() == 1
            result.first().message == "O valor precisa estar entre 20 e 240"
    }

    def "Not allow more  than 240 square meters"() {

        given: "A user whant to create a Property with more then 240 square meters"
            def request = Fixture.from(PropertyRequest.class).gimme("veryLargeArea")

        when: "Validate fields"
            def result = validator.validate(request);

        then: "A validation error is generated"
            result.size() == 1
            result.first().message == "O valor precisa estar entre 20 e 240"
    }

    def "Not allow out of terrain coordinate"() {

        given: "A user whant to create a Property with out of terrain coordinate"
            def request = Fixture.from(PropertyRequest.class).gimme("outOfTerrain")

        when: "Validate fields"
            def result = validator.validate(request);

        then: "A validation error is generated"
            result.size() == 2
    }



}
