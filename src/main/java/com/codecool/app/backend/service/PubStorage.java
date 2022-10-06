package com.codecool.app.backend.service;

import com.codecool.app.backend.model.Pub;
import com.codecool.app.backend.model.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class PubStorage {

    private Set<Pub> pubs;

    public PubStorage(Set<Pub> pubs) {
        this.pubs = new HashSet<>();
    }

    public void addPub(Pub pub) {
        pubs.add(pub);
    }

    public Set<Pub> getPubs() {
        return pubs;
    }


    private Pub getPubById(UUID id){
        for(Pub pub : pubs){
            if(pub.getId().equals(id)){
                return pub;
            }
        }
        throw new RuntimeException("User not found");
    }

    public void updatePub(UUID id, Pub updatedPub) {
        Pub pub = getPubById(id);
        pub.setName(updatedPub.getName());
        pub.setMenu(updatedPub.getMenu());
    }

    //might get redundant
    public Pub getPubByName(String name){
        for (Pub pub : pubs) {
            if (pub.getName().toLowerCase().equals(name.toLowerCase())){
                return pub;
            }
        }
        throw new RuntimeException("Pub not found");
    }

}
