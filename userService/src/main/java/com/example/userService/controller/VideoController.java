package com.example.userService.controller;

import com.example.userService.model.Video;
import com.example.userService.payload.VideoPayload;
import com.example.userService.service.VideoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/playlists/videos")
public class VideoController {
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

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

    @DeleteMapping ("{videoId}/remove")
    public boolean deleteById(@PathVariable Long videoId){
        return videoService.deleteById(videoId);
    }

}
