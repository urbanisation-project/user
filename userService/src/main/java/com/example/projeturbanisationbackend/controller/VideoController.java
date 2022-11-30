package com.example.projeturbanisationbackend.controller;

import com.example.projeturbanisationbackend.model.Video;
import com.example.projeturbanisationbackend.payload.VideoPayload;
import com.example.projeturbanisationbackend.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/videos")
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping("/")
    public List<VideoPayload> getAll() {
        return videoService.findAll().stream().map(Video::toPayload).collect(Collectors.toList());
    }

    @GetMapping("/{videoId}")
    public VideoPayload findById(@PathVariable Long videoId){
        return videoService.findById(videoId).toPayload();
    }

    @PostMapping("/save")
    public VideoPayload save(@RequestBody VideoPayload videoPayload){
        return videoService.save(videoPayload.toEntity()).toPayload();
    }

    @DeleteMapping("/{videoId}")
    public boolean deleteById(@PathVariable Long playlistId){
        return videoService.deleteById(playlistId);
    }

}
