package com.codecool.app.backend.controller;

import com.codecool.app.backend.model.Pub;
import com.codecool.app.backend.model.User;
import com.codecool.app.backend.service.PubStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RestController
public class PubController {

    private final PubStorage pubStorage;

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
    @GetMapping("pub/{name}")
    public Pub getPubByName(@PathVariable String name) {
        return pubStorage.getPubByName(name);
    }

    @DeleteMapping(value = "pubs/delete/{id}")
    public void deletePub(@PathVariable UUID id) {
        pubStorage.deletePub(id);
    }

}
