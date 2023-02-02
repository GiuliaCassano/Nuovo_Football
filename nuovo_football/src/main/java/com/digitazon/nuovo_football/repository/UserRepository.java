package com.digitazon.nuovo_football.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitazon.nuovo_football.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}

