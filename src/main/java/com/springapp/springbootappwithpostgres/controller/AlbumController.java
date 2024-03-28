package com.springapp.springbootappwithpostgres.controller;

import com.springapp.springbootappwithpostgres.dto.AlbumDto;
import com.springapp.springbootappwithpostgres.exception.AlbumNotFoundException;
import com.springapp.springbootappwithpostgres.model.AlbumInfo;
import com.springapp.springbootappwithpostgres.service.AlbumInfoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumInfoService service;

    public AlbumController(AlbumInfoService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create a New Album")
    public ResponseEntity<AlbumInfo> createCourse(@RequestBody AlbumDto albumDto) {
        Optional<AlbumInfo> newCourse = Optional.ofNullable(service.create(albumDto));
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newCourse.get().getId())
                .toUri();

        return ResponseEntity.created(location)
                .build();
    }

    @GetMapping
    @Operation(summary = "Find All Album Details")
    public ResponseEntity<List<AlbumInfo>> getAllCourses() {
        Optional<List<AlbumInfo>> albums = service.getAllAlbums();

        return albums.map(albumsDetails -> new ResponseEntity<>(albumsDetails, HttpStatus.OK))
                .orElseThrow(() -> new AlbumNotFoundException("No Albums are available.."));
    }

    @GetMapping("/{name}")
    @Operation(summary = "Find Album By Name")
    public ResponseEntity<AlbumInfo> getCourseByName(@PathVariable("name") String name) {
        Optional<AlbumInfo> albumInfo = service.getAlbumInfoByName(name);

        return albumInfo.map(albumInfoDetails -> new ResponseEntity<>(albumInfoDetails, HttpStatus.OK))
                .orElseThrow(() -> new AlbumNotFoundException("No Courses are available.."));

    }

    @GetMapping("/all/{names}")
    @Operation(summary = "Find Album By Name Like")
    public ResponseEntity<List<AlbumInfo>> getCourseByNameLike(@PathVariable("names") String names) {
        List<AlbumInfo> albumInfo = service.getAlbumInfoByNameIgnoreCaseContaining(names);

        return new ResponseEntity<>(albumInfo, HttpStatus.OK);

    }
}
