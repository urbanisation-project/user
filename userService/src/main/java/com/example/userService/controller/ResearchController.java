package com.example.userService.controller;

import com.example.userService.APIs.SearchKeywordDailymotionService;
import com.example.userService.APIs.SearchKeywordYoutubeService;
import com.example.userService.business.UseCase;
import com.example.userService.business.dto.VideoDTO;
import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/researches")
public class ResearchController {
    private final UseCase useCase;
    private final SearchKeywordYoutubeService searchKeywordYoutubeService;
    private final SearchKeywordDailymotionService searchKeywordDailymotionService;

    public ResearchController(UseCase useCase, SearchKeywordYoutubeService searchKeywordYoutubeService, SearchKeywordDailymotionService searchKeywordDailymotionService) {
        this.useCase = useCase;
        this.searchKeywordYoutubeService = searchKeywordYoutubeService;
        this.searchKeywordDailymotionService = searchKeywordDailymotionService;
    }

    @GetMapping("/youtube/{query}")
    List<VideoDTO> researchVideoYoutube(@PathVariable String query) throws JSONException {
        return useCase.getVideosFromApi(searchKeywordYoutubeService.getVideos(query));
    }
    @GetMapping("/dailymotion/{query}")
    List<VideoDTO> researchVideoDailymotion(@PathVariable String query) throws JSONException {
        return useCase.getVideosFromApi(searchKeywordDailymotionService.getVideos(query));
    }
}