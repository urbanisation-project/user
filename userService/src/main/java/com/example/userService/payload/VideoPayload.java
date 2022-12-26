package com.example.userService.payload;

import com.example.userService.model.Video;
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
    private PlaylistPayload playlist;

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
