package com.example.userService.repository;

import com.example.userService.model.Playlist;
import com.example.userService.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findVideosByPlaylist(Playlist playlist);
}
