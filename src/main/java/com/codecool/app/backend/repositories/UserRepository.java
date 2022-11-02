package com.codecool.app.backend.repositories;

import java.util.Optional;
import java.util.UUID;

import com.codecool.app.backend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findById(UUID id);

    Optional<User> findByName(String name);
}
