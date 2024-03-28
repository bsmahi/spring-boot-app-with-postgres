package com.springapp.springbootappwithpostgres.exception;

public class AlbumNotFoundException extends RuntimeException {

    public AlbumNotFoundException(String message) {
        super(message);
    }
}
