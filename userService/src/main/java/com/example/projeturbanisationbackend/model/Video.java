package com.example.projeturbanisationbackend.model;

import com.example.projeturbanisationbackend.payload.VideoPayload;
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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String link;
    private String miniature;
    private String description;
    private String title;

    // jsonObject is the return value of api package
    public Video(JSONObject jsonObject) throws JSONException {
        this.id = -10000L;
        this.link = jsonObject.getString("link");
        this.miniature = jsonObject.getString("thumbnail");
        this.description = jsonObject.getString("description");
        this.title = jsonObject.getString("title");
    }

    public VideoPayload toPayload() {
        return new VideoPayload(
                this.id,
                this.link,
                this.miniature,
                this.description,
                this.title
        );
    }
}
