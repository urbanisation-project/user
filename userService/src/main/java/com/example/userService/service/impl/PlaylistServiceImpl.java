package com.example.userService.service.impl;

import com.example.userService.model.Playlist;
import com.example.userService.repository.PlaylistRepository;
import com.example.userService.service.PlaylistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;


    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist update(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist findById(Long playlistId) {
        return playlistRepository.findById(playlistId).get();
    }

    @Override
    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public boolean deleteById(Long playlistId) {
        try {
            playlistRepository.deleteById(playlistId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
