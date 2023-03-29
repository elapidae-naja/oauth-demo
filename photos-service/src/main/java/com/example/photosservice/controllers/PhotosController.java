package com.example.photosservice.controllers;

import com.example.photosservice.response.PhotoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotosController {

    @GetMapping
    public List<PhotoResponse> getPhotos() {
        List<PhotoResponse> photoResponses = new ArrayList<>();
        photoResponses.add(new PhotoResponse("albumIdHere", "1","1", "Photo 1 title", "Photo 1 description", "Photo 1 URL"));
        photoResponses.add(new PhotoResponse("albumIdHere", "2","1", "Photo 2 title", "Photo 2 description", "Photo 2 URL"));
        return photoResponses;
    }

}
