package com.example.projeturbanisationbackend.service.impl;

import com.example.projeturbanisationbackend.model.Video;
import com.example.projeturbanisationbackend.repository.VideoRepository;
import com.example.projeturbanisationbackend.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImp implements VideoService {

    public final VideoRepository videoRepository;

    public VideoServiceImp(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
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
}
