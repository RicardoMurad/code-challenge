package com.vivareal.service;

import com.vivareal.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
public class PropertyService {

    public Property save(Property property) {
        property.setId(1L);
        return property;
    }

    public Optional<Property> findById(Long id) {
        return Optional.empty();
    }

    public Set<Property> findBy(Integer ax, Integer ay, Integer bx, Integer by) {
        return Collections.EMPTY_SET;
    }

}
