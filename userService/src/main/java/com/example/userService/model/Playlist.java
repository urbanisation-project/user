package com.example.userService.model;

import com.example.userService.payload.PlaylistPayload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    public Owner user;

    public PlaylistPayload toPayload(){
        return new PlaylistPayload(
                getId(),
                getName(),
                getUser().toPayload()
        );
    }
}
