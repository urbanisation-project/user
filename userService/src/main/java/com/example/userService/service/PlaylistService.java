package com.example.userService.service;

import com.example.userService.model.Playlist;
import com.example.userService.payload.PlaylistPayload;

import java.util.List;

public interface PlaylistService {

    Playlist save(Playlist playlist);
    Playlist update(Playlist update);
    Playlist findById(Long playlistId);
    List<Playlist> findAll();
    boolean deleteById(Long playlistId);
    List<PlaylistPayload> getUserPlaylists(Long userId);
}
