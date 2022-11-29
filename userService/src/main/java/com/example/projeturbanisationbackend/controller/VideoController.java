package com.example.projeturbanisationbackend.controller;

import com.example.projeturbanisationbackend.model.Playlist;
import com.example.projeturbanisationbackend.model.Video;
import com.example.projeturbanisationbackend.service.PlaylistService;
import com.example.projeturbanisationbackend.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping("/")
    public List<Video> getAll() {
        return videoService.findAll();
    }

    @GetMapping("/{videoId}")
    public Video findById(@PathVariable Long videoId){
        return videoService.findById(videoId);
    }

    @PostMapping("/save")
    public Video save(@RequestBody Video video){
        return videoService.save(video);
    }

    @DeleteMapping("/{videoId}")
    public boolean deleteById(@PathVariable Long playlistId){
        return videoService.deleteById(playlistId);
    }

}
