package com.example.userService.payload;

import com.example.userService.model.Playlist;
import com.example.userService.model.User;
import com.example.userService.model.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistPayload {
    private Long id;
    public String name;
    public User user;
    public List<Video> videos;

    public Playlist toEntity(){
        return new Playlist(
                this.id,
                this.name,
                this.user,
                this.videos
        );
    }
}
