package com.example.userService.controller;

import com.example.userService.business.UseCase;
import com.example.userService.business.dto.VideoDTO;
import com.example.userService.model.Playlist;
import com.example.userService.model.Video;
import com.example.userService.payload.PlaylistPayload;
import com.example.userService.payload.VideoPayload;
import com.example.userService.service.PlaylistService;
import com.example.userService.service.VideoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/playlists")
public class PlaylistController {
    private final PlaylistService playlistService;
    private final VideoService videoService;

    public PlaylistController(PlaylistService playlistService, UseCase useCase, VideoService videoService) {
        this.playlistService = playlistService;
        this.videoService = videoService;
    }

    @GetMapping("/")
    public List<PlaylistPayload> getAll() {
        return playlistService.findAll().stream().map(Playlist::toPayload).collect(Collectors.toList());
    }
    @PostMapping("/update")
    public PlaylistPayload update(@RequestBody PlaylistPayload playlistPayload){
        return playlistService.update(playlistPayload.toEntity()).toPayload();
    }

    @GetMapping("/{playlistId}")
    public PlaylistPayload findById(@PathVariable Long playlistId){
        return playlistService.findById(playlistId).toPayload();
    }

    @PostMapping("/save")
    public PlaylistPayload save(@RequestBody PlaylistPayload playlistPayload){
        return playlistService.save(playlistPayload.toEntity()).toPayload();
    }

    @PostMapping("/delete")
    public boolean deleteById(@RequestBody PlaylistPayload playlist){
        return playlistService.deleteById(playlist.getId());
    }

    @PostMapping("/{playlistId}/add-video")
    public PlaylistPayload addVideoToPlaylist(@PathVariable Long playlistId , @RequestBody VideoDTO video){
        Playlist playlist = playlistService.findById(playlistId).toPayload().toEntity();
        videoService.save(new Video(-1L,video.getLink(),video.getMiniature(),video.getDescription(),video.getTitle(),playlist));
        return playlist.toPayload();
    }
    @GetMapping("{playlistId}/videos")
    public List<VideoPayload> getPlaylistVideos(@PathVariable Long playlistId){
        return videoService.findVideosByPlaylistId(playlistId).stream().map(Video::toPayload).collect(Collectors.toList());
    }

}