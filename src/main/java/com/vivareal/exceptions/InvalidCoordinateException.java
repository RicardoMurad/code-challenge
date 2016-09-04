package com.vivareal.exceptions;

public class InvalidCoordinateException extends RuntimeException {

    public InvalidCoordinateException() {
        super("Coordenada inválida");
    }

}
