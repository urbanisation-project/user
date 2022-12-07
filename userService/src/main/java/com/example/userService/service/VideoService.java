package com.example.userService.service;

import com.example.userService.model.Video;

import java.util.List;

public interface VideoService {

    Video save(Video video);
    Video findById(Long videoId);
    List<Video> findAll();
    boolean deleteById(Long videoId);
}
