package com.vivareal.model;

import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.ImmutableSet.copyOf;

public enum Province {

    NOVA(new Coordinate(500L, 800L), new Coordinate(0L, 1400L)),
    GROOLA(new Coordinate(500L, 600L), new Coordinate(0L, 800L)),
    SCAVY(new Coordinate(0L, 500L), new Coordinate(600L, 0L)),
    JABY(new Coordinate(1000L, 1100L), new Coordinate(500L, 1400L)),
    RUJA(new Coordinate(1000L, 400L), new Coordinate(500L, 1100L)),
    GODE(new Coordinate(0L, 1000L), new Coordinate(500L, 600L));

    private final Coordinate upperLeft;
    private final Coordinate bootonRight;

    Province(Coordinate upperLeft, Coordinate bootonRight) {
        this.upperLeft = upperLeft;
        this.bootonRight = bootonRight;
    }

    public Coordinate getUpperLeft() {
        return upperLeft;
    }

    public Coordinate getBootonRight() {
        return bootonRight;
    }

    public Boolean isInsideProvince(Coordinate coordinate) {
        return (coordinate.getxPosition() >= upperLeft.getxPosition() &&
                coordinate.getxPosition() <= bootonRight.getxPosition() &&
                coordinate.getyPosition() <= upperLeft.getyPosition() &&
                coordinate.getyPosition() >= bootonRight.getyPosition());
    }

    public static Set<Province> getProvincesForCoordinate(Coordinate coordinate) {
        return copyOf(Province.values())
                .stream()
                .filter( p -> p.isInsideProvince(coordinate))
                .collect(Collectors.toSet());
    };

}