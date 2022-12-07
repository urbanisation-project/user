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
@RequestMapping("/api/playlists")
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

    @DeleteMapping("/{playlistId}")
    public boolean deleteById(@PathVariable Long playlistId){
        return playlistService.deleteById(playlistId);
    }

    @PostMapping("/add-to-playlist/{playlistPayloadId}")
    public PlaylistPayload addVideoToPlaylist(@PathVariable Long playlistPayloadId , @RequestBody VideoPayload videoPayload){
        PlaylistPayload playlistPayload = playlistService.findById(playlistPayloadId).toPayload();
        return playlistService.save(useCase.addVideoToPlaylist(playlistPayload, videoPayload).toEntity()).toPayload();
    }

    @PutMapping("/delete-from-playlist/{playlistPayloadId}")
    public PlaylistPayload deleteVideoFromPlaylist(@PathVariable Long playlistPayloadId, @RequestBody VideoPayload videoPayload){
        PlaylistPayload playlistPayload = playlistService.findById(playlistPayloadId).toPayload();
        //return playlistService.save(useCase.deleteVideo(playlistPayload, videoPayload).toEntity()).toPayload();
        PlaylistPayload playlistPayload1 = useCase.deleteVideo(playlistPayload, videoPayload);
        return playlistService.save(playlistPayload1.toEntity()).toPayload();
    }

}