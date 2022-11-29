package com.example.projeturbanisationbackend.service;

import com.example.projeturbanisationbackend.model.Playlist;

import java.util.List;

public interface PlaylistService {

    Playlist save(Playlist playlist);
    Playlist update(Playlist update);
    Playlist findById(Long playlistId);
    List<Playlist> findAll();
    boolean deleteById(Long playlistId);
}
