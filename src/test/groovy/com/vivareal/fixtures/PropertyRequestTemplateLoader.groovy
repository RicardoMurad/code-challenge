package com.vivareal.fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.vivareal.controller.request.PropertyRequest;

import java.math.BigDecimal;

class PropertyRequestTemplateLoader implements TemplateLoader {

    @Override
    public void load() {

        Fixture.of(PropertyRequest.class).addTemplate("valid", new Rule(){{
            add("title", random("Imóvel A", "Imóvel B", "Imóvel C"));
            add("xPosition", random(Long.class, range(0L, 1400L)));
            add("yPosition", random(Long.class, range(0L, 1000L)));
            add("price", random(BigDecimal.class, range(1L, 200L)));
            add("description", random("Imóvel em bom estado de conservação", "Imóvel legal"));
            add("beds", random(Integer.class,range(1, 5)));
            add("baths", random(Integer.class,range(1, 4)));
            add("squareMeters", random(Integer.class,range(20, 240)));
        }});

        Fixture.of(PropertyRequest.class).addTemplate("noBaths").inherits("valid", new Rule(){{
            add("baths", random(Integer.class, range(-100, 0)));
        }});

        Fixture.of(PropertyRequest.class).addTemplate("soMuchBaths").inherits("valid", new Rule(){{
            add("baths", random(Integer.class, range(6, 100)));
        }});

        Fixture.of(PropertyRequest.class).addTemplate("noBeds").inherits("valid", new Rule(){{
            add("beds", random(Integer.class, range(-100, 0)));
        }});

        Fixture.of(PropertyRequest.class).addTemplate("soMuchBeds").inherits("valid", new Rule(){{
            add("beds", random(Integer.class, range(6, 100)));
        }});

        Fixture.of(PropertyRequest.class).addTemplate("verySmallArea").inherits("valid", new Rule(){{
            add("squareMeters", random(Integer.class, range(0, 19)));
        }});

        Fixture.of(PropertyRequest.class).addTemplate("veryLargeArea").inherits("valid", new Rule(){{
            add("squareMeters", random(Integer.class, range(1000, 10000)));
        }});

        Fixture.of(PropertyRequest.class).addTemplate("outOfTerrain").inherits("valid", new Rule(){{
            add("xPosition", random(Long.class, range(2000, 50000)));
            add("yPosition", random(Long.class, range(3000, 4000)));
        }});

    }

}
