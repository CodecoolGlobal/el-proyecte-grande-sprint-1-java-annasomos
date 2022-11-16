package com.codecool.app.backend.storage;

import com.codecool.app.backend.model.Pub;
import com.codecool.app.backend.model.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class PubStorage {

    private final Set<Pub> pubs;

    public PubStorage() {
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
        pub.addProducts(updatedPub.getProducts());
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

    public void deletePub(UUID id) {
        Pub pub = getPubById(id);
        pubs.remove(pub);
    }
}
