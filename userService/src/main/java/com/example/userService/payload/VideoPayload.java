package com.example.userService.payload;

import com.example.userService.model.Video;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoPayload {
    private Long id;
    private String link;
    private String miniature;
    private String description;
    private String title;
    private PlaylistPayload playlist;

    public Video toEntity() {
        return new Video(
                getId(),
                getLink(),
                getMiniature(),
                getDescription(),
                getTitle(),
                getPlaylist().toEntity()
        );
    }

}
