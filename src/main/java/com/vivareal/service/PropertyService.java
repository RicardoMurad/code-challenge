package com.vivareal.service;

import com.vivareal.model.Property;
import com.vivareal.persistence.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository repository;

    public Property save(Property property) {
        return repository.save(property);
    }

    public Optional<Property> findById(Long id) {
        return repository.findById(id);
    }

    public Set<Property> findBy(Long ax, Long ay, Long bx, Long by) {
        return repository.find(ax, ay, bx, by);
    }

}
