package com.example.projeturbanisationbackend.model;

import com.example.projeturbanisationbackend.payload.PlaylistPayload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    public User user;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Video> videos;

    public PlaylistPayload toPayload(){
        return new PlaylistPayload(
                this.id,
                this.name,
                this.user,
                this.videos
        );
    }
}
