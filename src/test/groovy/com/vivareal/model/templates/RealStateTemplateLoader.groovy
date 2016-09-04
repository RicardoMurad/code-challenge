package com.vivareal.model.templates

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader
import com.vivareal.model.Coordinate
import com.vivareal.model.Provinces
import com.vivareal.model.RealEstate

class RealStateTemplateLoader implements TemplateLoader {


    @Override
    void load() {
        Fixture.of(RealEstate.class).addTemplate("valid", new Rule(){{
            add("title", "Imóvel código 34, com 4 quartos e 3 banheiros")
            add("price", random(BigDecimal.class, range(1L, 200L)))
            add("description", random("Imóvel em bom estado de conservação", "Imóvel legal"))
            add("coordinate", new Coordinate(999,333))
            add("beds", random(Integer.class,range(1, 5)))
            add("baths", random(Integer.class,range(1, 4)))
            add("squareMeters", random(Integer.class,range(20, 240)))
            add("provinces", [Provinces.SCAVY, Provinces.GODE] as List)
        }});
    }


}
