package com.example.userService.service.impl;

import com.example.userService.model.Video;
import com.example.userService.repository.VideoRepository;
import com.example.userService.service.PlaylistService;
import com.example.userService.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImp implements VideoService {

    public final VideoRepository videoRepository;
    public final PlaylistService playlistService;

    public VideoServiceImp(VideoRepository videoRepository, PlaylistService playlistService) {
        this.videoRepository = videoRepository;
        this.playlistService = playlistService;
    }

    @Override
    public Video save(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public Video findById(Long videoId) {
        return videoRepository.findById(videoId).get();
    }

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public boolean deleteById(Long videoId) {
        try {
            videoRepository.deleteById(videoId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Video> findVideosByPlaylistId(Long playlistId) {
        return videoRepository.findVideosByPlaylist(playlistService.findById(playlistId));
    }
}
