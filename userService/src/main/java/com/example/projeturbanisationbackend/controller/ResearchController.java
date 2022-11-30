package com.example.projeturbanisationbackend.controller;

import com.example.projeturbanisationbackend.APIs.SearchKeywordDailymotionService;
import com.example.projeturbanisationbackend.APIs.SearchKeywordYoutubeService;
import com.example.projeturbanisationbackend.business.UseCase;
import com.example.projeturbanisationbackend.payload.SearchKeyword;
import com.example.projeturbanisationbackend.payload.VideoPayload;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/research")
public class ResearchController {
    @Autowired
    UseCase useCase;
    @Autowired
    SearchKeywordYoutubeService searchKeywordYoutubeService;
    @Autowired
    SearchKeywordDailymotionService searchKeywordDailymotionService;

    @PostMapping("/youtube")
    List<VideoPayload> researchVideoYoutube(@RequestBody SearchKeyword searchKeyword) throws JSONException {
        return useCase.getVideosFromApi(searchKeywordYoutubeService.getVideos(searchKeyword));
    }
    @PostMapping("/dailymotion")
    List<VideoPayload> researchVideoDailymotion(@RequestBody SearchKeyword searchKeyword) throws JSONException {
        return useCase.getVideosFromApi(searchKeywordDailymotionService.getVideos(searchKeyword));
    }
}
