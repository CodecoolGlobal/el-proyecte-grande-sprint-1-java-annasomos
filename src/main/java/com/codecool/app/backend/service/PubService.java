package com.codecool.app.backend.service;

import com.codecool.app.backend.model.Pub;
import com.codecool.app.backend.repositories.PubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PubService {

    private final PubRepository pubRepository;

    @Autowired
    public PubService(PubRepository pubRepository) {
        this.pubRepository = pubRepository;
    }


    public Set<Pub> getPubs() {
        List<Pub> allPubs = pubRepository.findAll();
        return new HashSet<>(allPubs);
    }






}
