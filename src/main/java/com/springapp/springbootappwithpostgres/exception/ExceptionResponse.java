package com.springapp.springbootappwithpostgres.exception;

import java.time.LocalDateTime;

public record ExceptionResponse(LocalDateTime timestamp,
                                String message,
                                String details) {
}