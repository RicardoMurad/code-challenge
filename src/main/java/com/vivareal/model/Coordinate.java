package com.vivareal.model;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Coordinate {

    public Coordinate(Long xPosition, Long yPosition) {
        this.xPosition = requireNonNull(xPosition);
        this.yPosition = requireNonNull(yPosition);;
    }

    private  final Long xPosition;
    private final Long yPosition;

    public Long getxPosition() {
        return xPosition;
    }

    public Long getyPosition() {
        return yPosition;
    }

}