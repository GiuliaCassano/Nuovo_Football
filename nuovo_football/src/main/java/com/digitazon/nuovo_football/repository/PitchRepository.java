package com.digitazon.nuovo_football.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitazon.nuovo_football.model.Pitch;

public interface PitchRepository extends JpaRepository<Pitch, Long> {
    
}
