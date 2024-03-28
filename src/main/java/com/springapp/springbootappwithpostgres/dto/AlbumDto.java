package com.springapp.springbootappwithpostgres.dto;

import java.math.BigDecimal;

public record AlbumDto(String name,
                       String description,
                       BigDecimal price) {
}