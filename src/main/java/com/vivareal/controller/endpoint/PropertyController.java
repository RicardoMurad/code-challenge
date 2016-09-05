package com.vivareal.controller.endpoint;

import com.vivareal.controller.assembler.PropertyResourceAssembler;
import com.vivareal.controller.request.PropertyRequest;
import com.vivareal.controller.resource.PropertyResource;
import com.vivareal.model.Property;
import com.vivareal.model.exceptions.ValidationException;
import com.vivareal.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService service;

    @Autowired
    private PropertyResourceAssembler assembler;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public HttpEntity<PropertyResource> save(@Valid @RequestBody PropertyRequest request) {

        return new ResponseEntity<>(assembler.toResource(service.save(request.toEntity())), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<PropertyResource> findById(@PathVariable Long id) {

        return service.findById(id)
                        .map(p -> new ResponseEntity<>(assembler.toResource(p), HttpStatus.FOUND))
                        .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND) );

    }

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<Resources<PropertyResource>> find(Integer ax, Integer ay, Integer bx, Integer by) {

        List<PropertyResource> resources = assembler.toResources(service.findBy(ax, ay, bx, by));
        Resources<PropertyResource> wrapped = new Resources<>(resources);

        return new HttpEntity<>(wrapped);
    }

}