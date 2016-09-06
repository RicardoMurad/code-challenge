package com.vivareal.controller.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vivareal.model.Property;
import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

public class PropertyResource {

    private Long id;
    private String title;
    private BigDecimal price;
    private String description;

    @JsonProperty("x")
    private Long  xCoordinate;
    @JsonProperty("y") private Long  yCoordinate;

    private Integer beds;
    private Integer baths;
    private Set<String> provinces;
    private Integer squareMeters;

    public PropertyResource(Property property) {
        this.id = property.getId();
        this.title = property.getTitle();
        this.price = property.getPrice();
        this.description = property.getDescription();
        this.xCoordinate = property.getCoordinate().getxPosition();
        this.yCoordinate = property.getCoordinate().getyPosition();
        this.beds = property.getBeds();
        this.baths = property.getBaths();
        this.provinces = property.getProvinces()
                                    .stream()
                                    .map(p -> p.getName())
                                    .collect(Collectors.toSet());
        this.squareMeters = property.getSquareMeters();
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Long getxCoordinate() {
        return xCoordinate;
    }

    public Long getyCoordinate() {
        return yCoordinate;
    }

    public Integer getBeds() {
        return beds;
    }

    public Integer getBaths() {
        return baths;
    }

    public Set<String> getProvinces() {
        return provinces;
    }

    public Integer getSquareMeters() {
        return squareMeters;
    }

}
