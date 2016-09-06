package com.vivareal.model

import br.com.six2six.fixturefactory.Fixture
import com.vivareal.model.exceptions.InvalidCoordinateException
import spock.lang.Specification
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates

class PropertyTest extends Specification {

    def setup() {
        loadTemplates("com.vivareal.templates");
    }

    def "Not allow out of province X coordinate"() {

        given: "A user created a valid property"
            Property property = Fixture.from(Property.class).gimme("valid")

        when: "changed the province X coordinate to out of province area"
            property.setCoordinate(new Coordinate(20000 ,400))

        then: "A InvalidCoordinateException is thrown !!!"
            thrown InvalidCoordinateException
    }

    def "Not allow out of province Y coordinates"() {
        given: "A user created a valid property"
            Property property = Fixture.from(Property.class).gimme("valid")

        when: "changed the province X coordinate to out of province area"
            property.setCoordinate(new Coordinate(333,222200))

        then: "A InvalidCoordinateException is thrown !!!"
            thrown InvalidCoordinateException
    }

}
