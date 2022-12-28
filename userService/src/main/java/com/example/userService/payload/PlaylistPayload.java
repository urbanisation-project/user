package com.example.userService.payload;

import com.example.userService.model.Playlist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistPayload {
    private Long id;
    public String name;
    public UserPayload user;
    public Playlist toEntity(){
        return new Playlist(
                getId(),
                getName(),
                getUser().toEntity()
        );
    }
}
