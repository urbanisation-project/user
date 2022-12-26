package com.example.userService.controller;

import com.example.userService.business.UseCase;
import com.example.userService.model.Playlist;
import com.example.userService.payload.PlaylistPayload;
import com.example.userService.payload.VideoPayload;
import com.example.userService.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/playlists")
public class PlaylistController {
    @Autowired
    PlaylistService playlistService;
    @Autowired
    UseCase useCase;

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

    @DeleteMapping("/{playlistId}/delete")
    public boolean deleteById(@PathVariable Long playlistId){
        return playlistService.deleteById(playlistId);
    }

    @PostMapping("/{playlistId}/add-video")
    public PlaylistPayload addVideoToPlaylist(@PathVariable Long playlistId , @RequestBody VideoPayload videoPayload){
        PlaylistPayload playlistPayload = playlistService.findById(playlistId).toPayload();
        return playlistService.save(useCase.addVideoToPlaylist(playlistPayload, videoPayload).toEntity()).toPayload();
    }

    @PutMapping("/{playlistId}/remove-video")
    public PlaylistPayload deleteVideoFromPlaylist(@PathVariable Long playlistId, @RequestBody VideoPayload videoPayload){
        PlaylistPayload playlistPayload = playlistService.findById(playlistId).toPayload();
        PlaylistPayload playlistPayload1 = useCase.deleteVideo(playlistPayload, videoPayload);
        return playlistService.save(playlistPayload1.toEntity()).toPayload();
    }

}