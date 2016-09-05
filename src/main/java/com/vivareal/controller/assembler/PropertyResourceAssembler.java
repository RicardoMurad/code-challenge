package com.vivareal.controller.assembler;

import com.vivareal.controller.endpoint.PropertyController;
import com.vivareal.controller.resource.PropertyResource;
import com.vivareal.model.Property;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class PropertyResourceAssembler extends ResourceAssemblerSupport<Property, PropertyResource> {

    public PropertyResourceAssembler() {
        super(PropertyController.class, PropertyResource.class);
    }

    @Override
    public PropertyResource toResource(Property property) {
        return new PropertyResource(property);
    }

}