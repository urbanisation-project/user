package com.example.projeturbanisationbackend.payload;

import com.example.projeturbanisationbackend.model.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoPayload {
    private Long id;
    private String link;
    private String miniature;
    private String description;
    private String title;

    public Video toEntity() {
        return new Video(
                this.id,
                this.link,
                this.miniature,
                this.description,
                this.title
        );
    }

}