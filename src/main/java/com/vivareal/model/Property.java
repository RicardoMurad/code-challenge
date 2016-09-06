package com.vivareal.model;

import com.vivareal.model.exceptions.InvalidCoordinateException;
import java.math.BigDecimal;
import java.util.Set;
import static com.vivareal.model.Province.getProvincesForCoordinate;
import static java.util.Objects.requireNonNull;

public class Property {

    private Long id;
    private String title;
    private BigDecimal price;
    private String description;
    private Coordinate coordinate;
    private Integer beds;
    private Integer baths;
    private Set<Province> provinces;
    private Integer squareMeters;

    public Property() {}

    public Property(String title,
                    BigDecimal price,
                    String description,
                    Coordinate coordinate,
                    Integer beds,
                    Integer baths,
                    Integer squareMeters) {

        this.title = title;
        this.price = price;
        this.description = description;
        this.coordinate = coordinate;
        this.provinces = getProvincesForCoordinate(coordinate);
        this.beds = beds;
        this.baths = baths;
        this.squareMeters = squareMeters;
    }

    public void setCoordinate(Coordinate coordinate) {

        provinces.stream().forEach( province -> {
            if(!province.isInsideProvince(coordinate)) {
                throw new InvalidCoordinateException("Coordenada" + coordinate + " não faz parte da província" + province);
            }
        });

        this.coordinate = requireNonNull(coordinate);
    }

    public Long getX() {
        return coordinate.getxPosition();
    }

    public  Long getY() {
        return coordinate.getyPosition();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public void setBaths(Integer baths) {
        this.baths = baths;
    }

    public void setProvinces(Set<Province> provinces) {
        this.provinces = provinces;
    }

    public void setSquareMeters(Integer squareMeters) {
        this.squareMeters = squareMeters;
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

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Integer getBeds() {
        return beds;
    }

    public Integer getBaths() {
        return baths;
    }

    public Set<Province> getProvinces() {
        return provinces;
    }

    public Integer getSquareMeters() {
        return squareMeters;
    }
}
