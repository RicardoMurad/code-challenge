package com.vivareal.controller.endpoint;

import com.vivareal.controller.assembler.PropertyResourceAssembler;
import com.vivareal.controller.request.PropertyRequest;
import com.vivareal.controller.resource.PropertyResource;
import com.vivareal.controller.resource.PropertyResourceWrapper;
import com.vivareal.service.PropertyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@Api(value = "PROPERTIES", description = "Endpoints da entidade Property", position = 2)
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService service;

    @Autowired
    private PropertyResourceAssembler assembler;

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity<PropertyResource> save(@Valid @RequestBody PropertyRequest request) {
        return new ResponseEntity<>(assembler.toResource(service.save(request.toEntity())), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PropertyResource> findById(@PathVariable Long id) {
        return service.findById(id)
                        .map(p -> new ResponseEntity<>(assembler.toResource(p), HttpStatus.FOUND))
                        .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND) );
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<PropertyResourceWrapper> find(
                            @RequestParam(name = "ax", required = true) Long ax,
                            @RequestParam(name = "ay", required = true) Long ay,
                            @RequestParam(name = "bx", required = true) Long bx,
                            @RequestParam(name = "by", required = true) Long by) {

        Collection<PropertyResource> resources = assembler.toResources(service.findBy(ax, ay, bx, by));

        return new HttpEntity<>(new PropertyResourceWrapper(resources));
    }

}