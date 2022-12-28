package com.example.userService.business;

import com.example.userService.business.dto.VideoDTO;
import com.example.userService.model.Video;
import com.example.userService.payload.VideoPayload;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UseCase {

    public List<VideoDTO> getVideosFromApi(JSONArray jsonarray) throws JSONException {
        List<VideoDTO> listVideos = new ArrayList<>();
        for (int i = 0; i < jsonarray.length(); i++) {
            listVideos.add(new VideoDTO(jsonarray.getJSONObject(i)));
        }
        return listVideos;
    }

//    public PlaylistPayload addVideoToPlaylist(PlaylistPayload playlistPayload, VideoPayload videoPayload){
//        playlistPayload.getVideos().add(videoPayload.toEntity());
//        return playlistPayload;
//    }
//
//    public PlaylistPayload deleteVideo(PlaylistPayload playlistPayload,VideoPayload videoPayload){
//        playlistPayload.getVideos().remove(videoPayload.toEntity());
//        return playlistPayload;
//    }
}
