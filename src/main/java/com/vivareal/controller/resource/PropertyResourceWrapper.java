package com.vivareal.controller.resource;

import java.util.Collection;

public class PropertyResourceWrapper {

    Collection<PropertyResource> resources;

    public PropertyResourceWrapper(Collection<PropertyResource> resources) {
        this.resources = resources;
    }

    public Collection<PropertyResource> getProperties() {
        return resources;
    }

    public Integer getFoundProperties() {
        return resources.size();
    }

}
