package com.vivareal.fixtures

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader
import com.vivareal.model.Coordinate
import com.vivareal.model.Province
import com.vivareal.model.Property

class PropertyTemplateLoader implements TemplateLoader {

    @Override
    void load() {
        Fixture.of(Property.class).addTemplate("valid", new Rule(){{
            add("id", 1L)
            add("title", "Imóvel código 34, com 4 quartos e 3 banheiros")
            add("price", random(BigDecimal.class, range(1L, 200L)))
            add("description", random("Imóvel em bom estado de conservação", "Imóvel legal"))
            add("coordinate", new Coordinate(100L, 100L))
            add("beds", random(Integer.class,range(1, 5)))
            add("baths", random(Integer.class,range(1, 4)))
            add("squareMeters", random(Integer.class,range(20, 240)))
            add("provinces", [Province.GODE ] as List)
        }});
    }


}
