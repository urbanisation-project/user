package com.example.projeturbanisationbackend.repository;

import com.example.projeturbanisationbackend.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
