package com.example.userService.repository;

import com.example.userService.model.Owner;
import com.example.userService.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist,Long> {
    List<Playlist> findPlaylistsByUser(Owner user);
}
