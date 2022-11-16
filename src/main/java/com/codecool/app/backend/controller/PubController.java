package com.codecool.app.backend.controller;

import com.codecool.app.backend.model.Pub;
import com.codecool.app.backend.service.PubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PubController {

    private final PubService pubService;

    @Autowired
    public PubController(PubService pubService) {
        this.pubService = pubService;
    }

    @GetMapping("pubs")
    public Set<Pub> getPubs(){
        return pubService.getPubs();
    }

    @PostMapping("pub/new")
    public void addPub(@RequestBody Pub pub) {
        pubService.addPub(pub);
    }

    /*

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


     */

}
