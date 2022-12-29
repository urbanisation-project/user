package com.example.userService.service.impl;

import com.example.userService.model.Playlist;
import com.example.userService.payload.PlaylistPayload;
import com.example.userService.repository.PlaylistRepository;
import com.example.userService.service.PlaylistService;
import com.example.userService.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final UserService userService;


    public PlaylistServiceImpl(PlaylistRepository playlistRepository, UserService userService) {
        this.playlistRepository = playlistRepository;
        this.userService = userService;
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

    @Override
    public List<PlaylistPayload> getUserPlaylists(Long userId) {
        return playlistRepository.findPlaylistsByUser(userService.findById(userId)).stream().map(Playlist::toPayload).collect(Collectors.toList());
    }
}
