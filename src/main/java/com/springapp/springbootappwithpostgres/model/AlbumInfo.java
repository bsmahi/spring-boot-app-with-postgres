package com.springapp.springbootappwithpostgres.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "album_info_details")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "AlbumInfo.findByNameIgnoreCaseContaining", query = "select a from AlbumInfo a where a.name LIKE ?1")
public class AlbumInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "album_id")
    private long id;

    @Column(name = "album_name")
    private String name;

    @Column(name = "album_description")
    private String description;

    @Column(name = "album_price")
    private BigDecimal price;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
