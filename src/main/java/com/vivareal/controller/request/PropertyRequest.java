package com.vivareal.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vivareal.model.Coordinate;
import com.vivareal.model.Property;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PropertyRequest {

    @NotNull
    @Length(min = 5, max = 255)
    private String title;

    @NotNull
    @Range(min = 0, max = 1400)
    private Long xPosition;

    @NotNull
    @Range(min = 0, max = 1000)
    private Long yPosition;

    @NotNull
    private BigDecimal price;

    @NotNull
    @NotBlank
    @Length(min = 1, max = 1000)
    private String description;

    @NotNull
    @Range(min = 1 , max = 5)
    private Integer beds;

    @NotNull
    @Range(min = 1 , max = 4)
    private Integer baths;

    @NotNull
    @Range(min = 20 , max = 240)
    private Integer squareMeters;

    @JsonProperty("x")
    public void setxPosition(Long xPosition) {
        this.xPosition = xPosition;
    }

    @JsonProperty("y")
    public void setyPosition(Long yPosition) {
        this.yPosition = yPosition;
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

    public void setSquareMeters(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }

    public Property toEntity() {
        return new Property(title,
                            price,
                            description,
                            new Coordinate(xPosition, yPosition),
                            beds,
                            baths,
                            squareMeters);
    }

}
