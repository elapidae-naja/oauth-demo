package com.example.albumsservice.controllers;

import com.example.albumsservice.response.AlbumResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    @GetMapping
    public List<AlbumResponse> getAlbums() {
        List<AlbumResponse> albumResponseList = new ArrayList<>();
        albumResponseList.add(new AlbumResponse("albumIdHere", "1", "Album 1 title", "Album 1 description", "Album 1 URL"));
        albumResponseList.add(new AlbumResponse("albumIdHere", "1", "Album 2 title", "Album 2 description", "Album 2 URL"));
        return albumResponseList;
    }
}
