package com.example.projeturbanisationbackend.business;

import com.example.projeturbanisationbackend.model.Video;
import com.example.projeturbanisationbackend.payload.PlaylistPayload;
import com.example.projeturbanisationbackend.payload.VideoPayload;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UseCase {

    public List<VideoPayload> getVideosFromApi(JSONArray jsonarray) throws JSONException {
        List<Video> listVideos = new ArrayList<>();
        for (int i = 0; i < jsonarray.length(); i++) {
            listVideos.add(new Video(jsonarray.getJSONObject(i)));
        }
        return listVideos.stream().map(Video::toPayload).collect(Collectors.toList());
    }

    public PlaylistPayload addVideoToPlaylist(PlaylistPayload playlistPayload, VideoPayload videoPayload){
        playlistPayload.getVideos().add(videoPayload.toEntity());
        return playlistPayload;
    }

    public PlaylistPayload deleteVideo(PlaylistPayload playlistPayload,VideoPayload videoPayload){
        playlistPayload.getVideos().remove(videoPayload.toEntity());
        return playlistPayload;
    }
}
