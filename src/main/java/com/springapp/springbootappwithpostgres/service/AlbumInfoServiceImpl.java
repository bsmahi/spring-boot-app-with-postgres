package com.springapp.springbootappwithpostgres.service;

import com.springapp.springbootappwithpostgres.dto.AlbumDto;
import com.springapp.springbootappwithpostgres.model.AlbumInfo;
import com.springapp.springbootappwithpostgres.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumInfoServiceImpl implements AlbumInfoService {

    private final AlbumRepository repository;

    public AlbumInfoServiceImpl(AlbumRepository repository) {
        this.repository = repository;
    }

    @Override
    public AlbumInfo create(AlbumDto albumDto) {

        var albumInfo = new AlbumInfo();
        albumInfo.setName(albumDto.name());
        albumInfo.setDescription(albumDto.description());
        albumInfo.setPrice(albumDto.price());

        return repository.save(albumInfo);
    }

    @Override
    public Optional<List<AlbumInfo>> getAllAlbums() {
        return Optional.of(repository.findAll());
    }

    @Override
    public Optional<AlbumInfo> getAlbumInfoByName(String name) {
        return Optional.ofNullable(repository.findByName(name));
    }

    @Override
    public List<AlbumInfo> getAlbumInfoByNameIgnoreCaseContaining(String name) {
        return repository.findByNameIgnoreCaseContaining(name);
    }
}
