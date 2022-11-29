package com.example.projeturbanisationbackend.controller;

import com.example.projeturbanisationbackend.model.Playlist;
import com.example.projeturbanisationbackend.model.User;
import com.example.projeturbanisationbackend.service.PlaylistService;
import com.example.projeturbanisationbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {
    @Autowired
    PlaylistService playlistService;

    @GetMapping("/")
    public List<Playlist> getAll() {
        return playlistService.findAll();
    }

    @PostMapping("/update")
    public Playlist update(@RequestBody Playlist playlist){
        return playlistService.update(playlist);
    }

    @GetMapping("/{playlistId}")
    public Playlist findById(@PathVariable Long playlistId){
        return playlistService.findById(playlistId);
    }

    @PostMapping("/save")
    public Playlist save(@RequestBody Playlist playlist){
        return playlistService.save(playlist);
    }

    @DeleteMapping("/{playlistId}")
    public boolean deleteById(@PathVariable Long playlistId){
        return playlistService.deleteById(playlistId);
    }
    
}