package com.vivareal.model;

import com.vivareal.exceptions.InvalidCoordinateException;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

import static java.util.Objects.requireNonNull;

public class RealEstate {

    private Long id;
    private String title;
    private BigDecimal price;
    private String description;
    private Coordinate coordinate;
    private Integer beds;
    private Integer baths;
    private Set<Provinces> provinces;
    private Integer squareMeters;

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = requireNonNull(coordinate);
    }

}
