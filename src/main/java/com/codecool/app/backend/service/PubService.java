package com.codecool.app.backend.service;

import com.codecool.app.backend.dao.PubDao;
import com.codecool.app.backend.exception.PubAlreadyExistsException;
import com.codecool.app.backend.exception.UserAlreadyExistsException;
import com.codecool.app.backend.model.Pub;
import com.codecool.app.backend.repositories.PubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PubService implements PubDao {

    private final PubRepository pubRepository;

    @Autowired
    public PubService(PubRepository pubRepository) {
        this.pubRepository = pubRepository;
    }


    @Override
    public void addPub(Pub pub) {
        Optional<Pub> oldPub = pubRepository.findByName(pub.getName());
        if(oldPub.isPresent()) {
            throw new PubAlreadyExistsException(pub.getName());
        }
        pubRepository.save(pub);
    }

    @Override
    public Set<Pub> getPubs() {
        List<Pub> allPubs = pubRepository.findAll();
        return new HashSet<>(allPubs);
    }

    @Override
    public void updatePub(UUID id, Pub pub) {

    }

    @Override
    public void deletePub(UUID id) {

    }
}
