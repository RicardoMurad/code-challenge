package com.vivareal.persistence;

import com.vivareal.model.Property;

import java.util.Optional;
import java.util.Set;

public interface PropertyRepository {

    Property save(Property property);

    Optional<Property> findById(Long id);

    Set<Property> find(Long ax, Long ay, Long bx, Long by);

}
