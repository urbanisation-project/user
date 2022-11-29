package com.example.projeturbanisationbackend.service;

import com.example.projeturbanisationbackend.model.Playlist;
import com.example.projeturbanisationbackend.model.Video;

import java.util.List;

public interface VideoService {

    Video save(Video video);
    Video findById(Long videoId);
    List<Video> findAll();
    boolean deleteById(Long videoId);
}
