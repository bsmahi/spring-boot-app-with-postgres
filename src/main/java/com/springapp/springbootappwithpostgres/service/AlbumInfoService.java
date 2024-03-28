package com.springapp.springbootappwithpostgres.service;

import com.springapp.springbootappwithpostgres.dto.AlbumDto;
import com.springapp.springbootappwithpostgres.model.AlbumInfo;

import java.util.List;
import java.util.Optional;

public interface AlbumInfoService {

    AlbumInfo create(AlbumDto albumDto);

    Optional<List<AlbumInfo>> getAllAlbums();

    Optional<AlbumInfo> getAlbumInfoByName(String name);

    List<AlbumInfo> getAlbumInfoByNameIgnoreCaseContaining(String name);
}
