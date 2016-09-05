package com.vivareal.controller.request;

import com.vivareal.model.Coordinate;
import com.vivareal.model.Property;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PropertyRequest {

    @NotNull
    private String title;

    @NotNull
    @Range(min = 1, max = 1400)
    private Long x;

    @NotNull
    @Range(min = 1, max = 1000)
    private Long y;

    @NotNull
    private BigDecimal price;

    @NotNull
    @NotBlank
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

    public void setX(Long x) {
        this.x = x;
    }

    public void setY(Long y) {
        this.y = y;
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

        Coordinate coordinate = new Coordinate(x, y);


        return new Property(title,
                            price,
                            description,
                            new Coordinate(x, y),
                            beds,
                            baths,
                            squareMeters);
    }

}
