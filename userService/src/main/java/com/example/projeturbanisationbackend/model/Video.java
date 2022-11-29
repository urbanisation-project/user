package com.example.projeturbanisationbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Video {
    @Id
    private Long id;
    private String link;
    private String miniature;
    private String description;
    private String tags;
    private String title;

    // jsonObject is the return value of api package
    public Video(JSONObject jsonObject) throws JSONException {
        this.link = jsonObject.getString("link");
        this.miniature = jsonObject.getString("miniature");
        this.description = jsonObject.getString("description");
        this.tags = jsonObject.getString("tags");
        this.title = jsonObject.getString("title");
    }
}
