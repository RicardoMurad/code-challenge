package com.vivareal.model;

import static java.util.Objects.requireNonNull;

public class Coordinate {

    private  final Long xPosition;
    private final Long yPosition;

    public Coordinate(Long xPosition, Long yPosition) {
        this.xPosition = requireNonNull(xPosition);
        this.yPosition = requireNonNull(yPosition);;
    }

    public Long getxPosition() {
        return xPosition;
    }

    public Long getyPosition() {
        return yPosition;
    }

    @Override
    public String toString() {
        return "(" + xPosition +
                " , " + yPosition +
                ')';
    }

}
