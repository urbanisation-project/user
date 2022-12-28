package com.example.userService.model;

import com.example.userService.payload.VideoPayload;
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
    @ManyToOne
    private Playlist playlist;

    public VideoPayload toPayload() {
        return new VideoPayload(
                getId(),
                getLink(),
                getMiniature(),
                getDescription(),
                getTitle(),
                getPlaylist().toPayload()
        );
    }
}
