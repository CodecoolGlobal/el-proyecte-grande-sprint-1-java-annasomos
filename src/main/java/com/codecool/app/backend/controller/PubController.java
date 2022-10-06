package com.codecool.app.backend.controller;

import com.codecool.app.backend.model.Pub;
import com.codecool.app.backend.model.User;
import com.codecool.app.backend.service.PubStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
public class PubController {

    public PubStorage pubStorage;

    @Autowired
    public PubController(PubStorage pubStorage) {
        this.pubStorage = pubStorage;
    }
    
    @GetMapping("pubs")
    public Set<Pub> getPubs() {
        return pubStorage.getPubs();
    }

    @PostMapping(value = "pubs/new")
    public void addPub(@RequestBody Pub pub) {
        pubStorage.addPub(pub);
    }

    @PutMapping("updatepub/{id}")
    public void updatePub(@PathVariable UUID id, @RequestBody Pub pub) {
        pubStorage.updatePub(id, pub);
    }

    //might get redundant
    @PutMapping("pub/{name}")
    public void getPubByName(@PathVariable String name) {
        pubStorage.getPubByName(name);
    }

}
