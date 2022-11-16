package com.codecool.app.backend.dao;

import com.codecool.app.backend.model.Pub;

import java.util.Set;
import java.util.UUID;

public interface PubDao {

    void addPub(Pub pub);
    Set<Pub> getPubs();

    void updatePub(UUID id, Pub pub);

    void deletePub(UUID id);

}
