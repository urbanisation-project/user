package com.example.userService.controller;

import com.example.userService.APIs.SearchKeywordDailymotionService;
import com.example.userService.APIs.SearchKeywordYoutubeService;
import com.example.userService.business.UseCase;
import com.example.userService.business.dto.VideoDTO;
import com.example.userService.payload.SearchKeyword;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/researches")
public class ResearchController {
    @Autowired
    UseCase useCase;
    @Autowired
    SearchKeywordYoutubeService searchKeywordYoutubeService;
    @Autowired
    SearchKeywordDailymotionService searchKeywordDailymotionService;

    @PostMapping("/youtube")
    List<VideoDTO> researchVideoYoutube(@RequestBody SearchKeyword searchKeyword) throws JSONException {
        return useCase.getVideosFromApi(searchKeywordYoutubeService.getVideos(searchKeyword));
    }
    @PostMapping("/dailymotion")
    List<VideoDTO> researchVideoDailymotion(@RequestBody SearchKeyword searchKeyword) throws JSONException {
        return useCase.getVideosFromApi(searchKeywordDailymotionService.getVideos(searchKeyword));
    }
}