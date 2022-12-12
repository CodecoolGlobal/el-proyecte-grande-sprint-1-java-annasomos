package com.codecool.app.backend.service;

import com.codecool.app.backend.exception.PubAlreadyExistsException;
import com.codecool.app.backend.model.Pub;
import com.codecool.app.backend.repositories.PubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PubService {

    private final PubRepository pubRepository;

    @Autowired
    public PubService(PubRepository pubRepository) {
        this.pubRepository = pubRepository;
    }


    public void addPub(Pub pub) {
        Optional<Pub> oldPub = pubRepository.findByName(pub.getName());
        if(oldPub.isPresent()) {
            throw new PubAlreadyExistsException(pub.getName());
        }
        pubRepository.save(pub);
    }

    public Set<Pub> getPubs() {
        List<Pub> allPubs = pubRepository.findAll();
        return new HashSet<>(allPubs);
    }

}
