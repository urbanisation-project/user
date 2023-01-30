package com.example.userService.business.dto;

import com.example.userService.model.Playlist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDTO {
    private String link;
    private String miniature;
    private String description;
    private String title;
    // jsonObject is the return value of api package
    public VideoDTO(JSONObject jsonObject) throws JSONException {
        this.link = jsonObject.getString("link");
        this.miniature = jsonObject.getString("thumbnail");
        this.description = jsonObject.getString("description");
        this.title = jsonObject.getString("title");
    }
}
