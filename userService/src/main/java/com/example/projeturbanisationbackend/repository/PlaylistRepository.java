package com.example.projeturbanisationbackend.repository;

import com.example.projeturbanisationbackend.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist,Long> {
}
