package com.vivareal.model;

import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.ImmutableSet.copyOf;
import static org.apache.commons.lang.StringUtils.capitalize;

public enum Province {

    GODE(new Coordinate(0L, 1000L), new Coordinate(600L, 500L)),
    RUJA(new Coordinate(400L, 1000L), new Coordinate(1100L, 500L)),
    JABY(new Coordinate(1100L, 1000L), new Coordinate(1400L, 500L)),
    SCAVY(new Coordinate(0L, 500L), new Coordinate(600L, 0L)),
    GROOLA(new Coordinate(600L, 500L), new Coordinate(800L, 0L)),
    NOVA(new Coordinate(800L, 500L), new Coordinate(1400L, 0L));

    private final Coordinate upperLeft;
    private final Coordinate botonRight;

    Province(Coordinate upperLeft, Coordinate botonRight) {
        this.upperLeft = upperLeft;
        this.botonRight = botonRight;
    }

    public Coordinate getUpperLeft() {
        return upperLeft;
    }

    public Coordinate getBotonRight() {
        return botonRight;
    }

    public String getName() {
        return capitalize(toString().toLowerCase());
    }

    public Boolean isInsideProvince(Coordinate coordinate) {
        return (coordinate.getxPosition() >= upperLeft.getxPosition() &&
                coordinate.getxPosition() <= botonRight.getxPosition() &&
                coordinate.getyPosition() <= upperLeft.getyPosition() &&
                coordinate.getyPosition() >= botonRight.getyPosition());
    }

    public static Set<Province> getProvincesForCoordinate(Coordinate coordinate) {
        return copyOf(Province.values())
                .stream()
                .filter( p -> p.isInsideProvince(coordinate))
                .collect(Collectors.toSet());
    };

}