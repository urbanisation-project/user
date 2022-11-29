package com.example.projeturbanisationbackend.business;

import com.example.projeturbanisationbackend.model.Playlist;
import com.example.projeturbanisationbackend.model.Video;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UseCase {

    public List<Video> getVideosFromApi(JSONArray jsonarray) throws JSONException {
        List<Video> listVideos = new ArrayList<>();
        for (int i = 0; i < jsonarray.length(); i++) {
            listVideos.add(new Video(jsonarray.getJSONObject(i)));
        }
        return listVideos;
    }

    public Playlist addVideoToPlaylist(Playlist playlist,Video video){
        playlist.getVideos().add(video);
        return playlist;
    }

    public Playlist deleteVideo(Playlist playlist,Video video){
        playlist.getVideos().remove(video);
        return playlist;
    }
}
