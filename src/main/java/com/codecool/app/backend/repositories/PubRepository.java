package com.codecool.app.backend.repositories;

import com.codecool.app.backend.model.Pub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PubRepository extends JpaRepository<Pub, UUID> {
}
