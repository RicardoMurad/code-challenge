package com.vivareal.persistence;

import com.vivareal.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Long.valueOf;

/**
 *  Just to simulate a real repository
 */
@Repository
public class FakePropertyRepository implements PropertyRepository {

    private Set<Property> data;

    @Autowired
    private Validator validator;

    @PostConstruct
    public void init() {
        this.data = new HashSet<>();
    }

    @Override
        public Property save(Property property) {
        property.setId(valueOf(data.size() + 1));
        data.add(property);
        return property;
    }

    @Override
    public Optional<Property> findById(Long id) {
        return data.stream().filter(p -> p.getId() == id).findFirst();

    }

    @Override
    public Set<Property> find(Long ax, Long ay, Long bx, Long by) {
        return data.stream().filter(property -> property.getX()  >= ax && property.getX() <= bx &&
                property.getY() <= ay && property.getY() >= by).collect(Collectors.toSet());
    }

}