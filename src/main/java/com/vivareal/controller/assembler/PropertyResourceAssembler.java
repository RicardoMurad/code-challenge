package com.vivareal.controller.assembler;

import com.vivareal.controller.resource.PropertyResource;
import com.vivareal.model.Property;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class PropertyResourceAssembler {

    public PropertyResource toResource(Property property) {
        return new PropertyResource(property);
    }

    public Collection<PropertyResource> toResources(Collection<Property> properties){
        return properties.stream().map(p -> new PropertyResource(p)).collect(Collectors.toList());
    }

}