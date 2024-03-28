package com.springapp.springbootappwithpostgres.repository;

import com.springapp.springbootappwithpostgres.model.AlbumInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumInfo, Long> {

    AlbumInfo findByName(String name);

    @Query(value = "SELECT * FROM ALBUM_INFO_DETAILS WHERE ALBUM_DESCRIPTION = ?1", nativeQuery = true)
    AlbumInfo findByDescription(String description);

    List<AlbumInfo> findByNameOrDescription(String name, String description);

    List<AlbumInfo> findByNameAndDescription(String name, String description);

    AlbumInfo findDistinctByName(String name);

    List<AlbumInfo> findByPriceGreaterThan(BigDecimal price);

    List<AlbumInfo> findByPriceLessThan(BigDecimal price);

    List<AlbumInfo> findByNameIgnoreCaseContaining(String name);

    List<AlbumInfo> findByNameLike(String name);

    List<AlbumInfo> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    List<AlbumInfo> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);
}
